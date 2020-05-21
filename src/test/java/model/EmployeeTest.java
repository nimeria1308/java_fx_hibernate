package model;

import org.junit.Test;
import simonadimitrova.electricitycompany.model.entities.Employee;

import java.math.BigDecimal;

public class EmployeeTest {
    @Test
    public void testConstraints() {
        ValidationUtil.assertValidationFails(new Employee(10, "", new BigDecimal(0)));
        ValidationUtil.validate(new Employee(10, "Simona Dimitrova", new BigDecimal(10000)));
    }
}
