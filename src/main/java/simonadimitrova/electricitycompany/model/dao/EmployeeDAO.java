package simonadimitrova.electricitycompany.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import simonadimitrova.electricitycompany.model.configuration.HibernateUtil;
import simonadimitrova.electricitycompany.model.entities.Employee;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDAO {
    public static void save(Employee employee) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public static void saveOrUpdate(Employee employee) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static void save(List<Employee> employees) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            employees.stream().forEach((e) -> session.save(e));
            transaction.commit();
        }
    }

    public static Employee get(long id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            transaction.commit();
            return employee;
        }
    }

    public static Employee load(long id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.load(Employee.class, id);
            transaction.commit();
            return employee;
        }
    }

    public static List<Employee> getAll() {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        }
    }

    public static void delete(Employee employee) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

    public static BigDecimal sumSalaries() {
        try (Session session = HibernateUtil.openSession()) {
            BigDecimal result = session.createQuery("SELECT SUM(salary) FROM Employee employee", BigDecimal.class).getSingleResult();
            if (result == null) {
                return new BigDecimal(0);
            }
            return result;
        }
    }
}
