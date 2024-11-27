package ru.employee_book.book_employee.excteption;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

    public EmployeeStorageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
