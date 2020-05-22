package model;

import org.junit.Test;
import simonadimitrova.electricitycompany.model.dao.EmployeeDAO;
import simonadimitrova.electricitycompany.model.entities.Employee;

import java.math.BigDecimal;

public class EmployeeTest {
    @Test
    public void testConstraints() {
        ValidationUtil.assertValidationFails(new Employee("", new BigDecimal(0)));
        ValidationUtil.validate(new Employee("Simona Dimitrova", new BigDecimal(10000)));
    }

    @Test
    public void testDAO() {
        Employee e;

        // create
        e = new Employee("Simona Dimitrova", new BigDecimal(10000));
        EmployeeDAO.saveOrUpdate(e);

        // update
        e.setSalary(new BigDecimal(11000));
        EmployeeDAO.saveOrUpdate(e);

        // retrieve via get
        e = EmployeeDAO.get(1);
        e.setSalary(new BigDecimal(12000));
        EmployeeDAO.saveOrUpdate(e);

        // create a new one
        e = new Employee("John Doe", new BigDecimal(1234.00));
        EmployeeDAO.saveOrUpdate(e);

        // List all employees
        EmployeeDAO.getAll().stream().forEach((em) -> System.out.println(em));

        // delete the second employee
        EmployeeDAO.delete(e);

        // List all employees
        EmployeeDAO.getAll().stream().forEach((em) -> System.out.println(em));
    }
}
