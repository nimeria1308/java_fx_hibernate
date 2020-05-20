/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import simonadimitrova.electricitycompany.model.configuration.ConfigurationUrlUtil;
import simonadimitrova.electricitycompany.model.configuration.HibernateUtil;

/**
 *
 * @author nimer
 */
public class TestUtil {

    static {
        ConfigurationUrlUtil.URL = SessionTest.class.getResource("hibernate.cfg.xml");
    }

    public static Session openSession() throws HibernateError {
        return HibernateUtil.openSession();
    }
}
