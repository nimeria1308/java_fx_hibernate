/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model;

import org.junit.Test;

/**
 *
 * @author nimer
 */
public class SessionTest {

    @Test
    public void openSession() throws Exception {
        TestUtil.openSession().close();
    }
}
