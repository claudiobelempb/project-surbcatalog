package br.com.surb.surbcatalog.modules.allocation.entities;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 7642423862074714472L;

    private String name;
    private String email;

    public Employee() {
    }

    public Employee(EmployeeBuilder employeeBuilder) {
        name = employeeBuilder.name;
        email = employeeBuilder.email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static EmployeeBuilder newEmployee() {
        return new EmployeeBuilder();
    }

    public static final class EmployeeBuilder {
        private String name;
        private String email;

        private EmployeeBuilder() {
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
