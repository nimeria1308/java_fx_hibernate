package simonadimitrova.electricitycompany.model.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

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

