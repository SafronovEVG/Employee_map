package ru.employee_book.book_employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.employee_book.book_employee.domian.Employee;
import ru.employee_book.book_employee.excteption.EmployeeAlreadyAddedException;
import ru.employee_book.book_employee.excteption.EmployeeNotFoundException;
import ru.employee_book.book_employee.service.api.EmployeeService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String addEmployee(@RequestParam String name, @RequestParam String surname) {
        Employee employee = new Employee(name, surname);
        try {
            return employeeService.addEmployee(employee);
        } catch (EmployeeAlreadyAddedException e) {
            return "Сотрудник есть в базе";
        }
    }

    @RequestMapping("/all")
    public Collection<Employee> all() {
        return employeeService.findAllEmployees();
    }

    @RequestMapping("/remove")
    public String removeEmployeeForNameAndSurname(@RequestParam Integer id) {
        try {
            employeeService.removeEmployee(id);
            return "Пользователь удален";
        } catch (EmployeeNotFoundException e) {
            return "Пользователь не найден";
        }
    }

    @RequestMapping("/find")
    public Employee find(@RequestParam Integer id) {
        return employeeService.findEmployee(id);
    }
}
