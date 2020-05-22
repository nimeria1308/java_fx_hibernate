package model;

import org.junit.Test;
import simonadimitrova.electricitycompany.model.dao.EmployeeDAO;
import simonadimitrova.electricitycompany.model.entities.Employee;

import java.math.BigDecimal;

public class ModelTest {
    @Test
    public void fillDatabaseTest() {
        fillDatabase();
    }

    public static void fillDatabase() {
        EmployeeDAO.saveOrUpdate(new Employee("Ivan Ivanov", new BigDecimal(3000)));
        EmployeeDAO.saveOrUpdate(new Employee("Georgi Ivanov", new BigDecimal(1200)));
        EmployeeDAO.saveOrUpdate(new Employee("Dimitar Georgiev", new BigDecimal(750)));
        EmployeeDAO.saveOrUpdate(new Employee("Svetla Petrova", new BigDecimal(4200)));
        EmployeeDAO.saveOrUpdate(new Employee("Milena Evlogieva", new BigDecimal(1920)));
        EmployeeDAO.saveOrUpdate(new Employee("Atanas Ivanov", new BigDecimal(1800)));
        EmployeeDAO.saveOrUpdate(new Employee("Georgi Atanasov", new BigDecimal(1100)));
        EmployeeDAO.saveOrUpdate(new Employee("Lilia Peeva", new BigDecimal(900)));
    }
}
