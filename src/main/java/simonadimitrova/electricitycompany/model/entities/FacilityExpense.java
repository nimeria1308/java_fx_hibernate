package simonadimitrova.electricitycompany.model.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "facility_expense")
public class FacilityExpense {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "facility_id", updatable = false, nullable = false)
    private Facility facility;

    @PastOrPresent(message = "date cannot be in the future")
    @Column(name = "expense_date", nullable = false)
    private Date date;

    @DecimalMin(value = "1", message = "expense must be positive")
    @Column(name = "value", nullable = false)
    private BigDecimal value; // in BGN
}
