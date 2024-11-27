package ru.employee_book.book_employee.service.impl;

import org.springframework.stereotype.Service;
import ru.employee_book.book_employee.domian.Employee;
import ru.employee_book.book_employee.excteption.EmployeeAlreadyAddedException;
import ru.employee_book.book_employee.excteption.EmployeeNotFoundException;
import ru.employee_book.book_employee.service.api.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> EMPLOYEE_MAP = new HashMap<>();

    @Override
    public String addEmployee(Employee employee) {
        EMPLOYEE_MAP.put(employee.getId(), employee);
        return "пользователь содан";
    }

    @Override
    public void removeEmployee(Integer id) {
        if(!EMPLOYEE_MAP.containsKey(id)) throw new EmployeeNotFoundException();
        EMPLOYEE_MAP.remove(id);
    }

    @Override
    public Employee findEmployee(Integer id) {
        if(!EMPLOYEE_MAP.containsKey(id)) throw new EmployeeNotFoundException();
        return EMPLOYEE_MAP.get(id);
    }

    @Override
    public Collection<Employee> findAllEmployees() {
        return EMPLOYEE_MAP.values();
    }
}
