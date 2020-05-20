/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author nimer
 */
public class FacilityExpense {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "facility_id", updatable = false, nullable = false)
    private Facility facility;

    @Past(message = "date must be in the past")
    @Column(name = "expense_date", nullable = false)
    private Date date;

    @DecimalMin(value = "1", message = "expense must be positive")
    @Digits(integer = 5, fraction = 3, message = "price value must be of the format XXXXX.YYY")
    @Column(name = "value", nullable = false)
    private BigDecimal value; // in BGN
}
