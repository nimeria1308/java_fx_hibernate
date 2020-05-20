/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author nimer
 */
@Entity
@Table(name = "client_measurement")
public class ClientMeasurement {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "client_id", updatable = false, nullable = false)
    private Client client;

    @Past(message = "date must be in the past")
    @Column(name = "measurement_date", nullable = false)
    private LocalDateTime date;

    @DecimalMin(value = "0", message = "measurement value must be positive")
    @Digits(integer = 5, fraction = 3, message = "measurement value must be of the format XXXXX.YYY")
    @Column(name = "value", nullable = false)
    private BigDecimal value; // in KWh
}
