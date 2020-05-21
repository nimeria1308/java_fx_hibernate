package model;

import org.junit.Test;
import simonadimitrova.electricitycompany.model.configuration.HibernateUtil;

public class SessionTest {

    @Test
    public void openSession() throws Exception {
        HibernateUtil.openSession().close();
    }
}
