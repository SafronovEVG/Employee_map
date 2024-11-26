package ru.employee_book.book_employee.service.impl;

import org.springframework.stereotype.Service;
import ru.employee_book.book_employee.domian.Employee;
import ru.employee_book.book_employee.excteption.EmployeeAlreadyAddedException;
import ru.employee_book.book_employee.excteption.EmployeeNotFoundException;
import ru.employee_book.book_employee.service.api.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    @Override
    public String addEmployee(Employee employee) {
        if (employeeMap.containsValue(employee)) throw new EmployeeAlreadyAddedException();
        employeeMap.put(employee.getId(), employee);
        return "пользователь содан";
    }

    @Override
    public void removeEmployee(Integer id) {
        if(!employeeMap.containsKey(id)) throw new EmployeeNotFoundException();
        employeeMap.remove(id);
    }

    @Override
    public Employee findEmployee(Integer id) {
        if(!employeeMap.containsKey(id)) throw new EmployeeNotFoundException();
        return employeeMap.get(id);
    }

    @Override
    public Map<Integer, Employee> findAllEmployees() {
        return employeeMap;
    }
}
