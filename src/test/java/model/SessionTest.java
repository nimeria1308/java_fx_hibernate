package model;

import org.junit.Test;

public class SessionTest {

    @Test
    public void openSession() throws Exception {
        TestUtil.openSession().close();
    }
}
