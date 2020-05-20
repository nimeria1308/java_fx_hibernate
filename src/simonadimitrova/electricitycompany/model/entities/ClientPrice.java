/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author nimer
 */
@Entity
@Table(name = "client_price")
public class ClientPrice {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_type", nullable = false)
    private Client.Type clientType;

    @DecimalMin(value = "0.001", message = "price value must be greater than zero")
    @Digits(integer = 5, fraction = 3, message = "price value must be of the format XXXXX.YYY")
    @Column(name = "value", nullable = false)
    private BigDecimal value; // per KWh
}
