/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.configuration;

import java.net.URL;

/**
 *
 * @author nimer
 */
public class ConfigurationUrlUtil {
    public static final URL DEFAULT_URL = ConfigurationUrlUtil.class.getResource("hibernate.cfg.xml");
    public static URL URL = DEFAULT_URL;
}
