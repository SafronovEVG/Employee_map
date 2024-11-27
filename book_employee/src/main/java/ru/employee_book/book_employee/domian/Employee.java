package ru.employee_book.book_employee.domian;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private int id;
    private static int count = 1;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        id = increment();
    }

    public int increment() {
        return count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname)
                && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
