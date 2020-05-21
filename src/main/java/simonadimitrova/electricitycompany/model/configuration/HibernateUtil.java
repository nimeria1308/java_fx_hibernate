package simonadimitrova.electricitycompany.model.configuration;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import simonadimitrova.electricitycompany.model.entities.*;

import java.net.URL;

public class HibernateUtil {

    private static final URL URL = Object.class.getResource("/hibernate.cfg.xml");

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
                    .configure(URL);
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