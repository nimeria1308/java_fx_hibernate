/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author nimer
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern.List({
        @Pattern(regexp = "$[A-Z]", message = "Name must start with a capital letter"),
        @Pattern(regexp = "$[A-Za-z ]+", message = "Name can contain only letters and spaces"),})
    @Column(name = "name", nullable = false)
    private String name;

    @DecimalMin(value = "610.00", message = "price value must be greater than zero")
    @Digits(integer = 5, fraction = 3, message = "price value must be of the format XXXXX.YYY")
    @Column(name = "salary", nullable = false)
    private BigDecimal salary; // in BGN

    public Employee() {
    }

    public Employee(long id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
