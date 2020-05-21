package simonadimitrova.electricitycompany.model.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

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
    private Date date;

    @DecimalMin(value = "0", message = "measurement value must be positive")
    @Digits(integer = 5, fraction = 3, message = "measurement value must be of the format XXXXX.YYY")
    @Column(name = "value", nullable = false)
    private BigDecimal value; // in KWh
}
