package ru.employee_book.book_employee.service.api;

import ru.employee_book.book_employee.domian.Employee;

import java.util.Collection;

public interface EmployeeService {

    String addEmployee(Employee employee);

    void removeEmployee(Integer id);

    Employee findEmployee(Integer id);

    Collection<Employee> findAllEmployees();
}
