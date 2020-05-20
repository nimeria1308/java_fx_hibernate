/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.facilities;

import java.util.Date;

/**
 *
 * @author nimer
 */
public class Expense {
    private int id;
    // one to one
    private Facility facility;
    private Date date;
    private double value; // in BGN
}
