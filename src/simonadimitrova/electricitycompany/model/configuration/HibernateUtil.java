/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.configuration;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import simonadimitrova.electricitycompany.model.entities.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author nimer
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(ClientMeasurement.class)
                    .addAnnotatedClass(ClientPrice.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Facility.class)
                    .addAnnotatedClass(FacilityExpense.class)
                    .configure(ConfigurationUrlUtil.URL);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() throws HibernateError {
        return sessionFactory.openSession();
    }
}
