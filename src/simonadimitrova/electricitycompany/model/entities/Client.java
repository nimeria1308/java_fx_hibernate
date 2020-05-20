/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.util.List;

/**
 *
 * @author nimer
 */
public class Client {
    private int id;
    private String name;
    private ClientType type;
    // one to many
    private List<ClientMeasurement> measurements;
}
