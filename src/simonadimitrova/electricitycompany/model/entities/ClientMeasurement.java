/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.util.Date;

/**
 *
 * @author nimer
 */
public class ClientMeasurement {
    private int id;
    // one to one
    private Client client;
    private Date date;
    private double measurement; // in KWh
}
