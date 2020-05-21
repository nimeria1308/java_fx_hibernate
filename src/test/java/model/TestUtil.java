package model;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import simonadimitrova.electricitycompany.model.configuration.HibernateUtil;

public class TestUtil {
    public static Session openSession() throws HibernateError {
        return HibernateUtil.openSession();
    }
}
