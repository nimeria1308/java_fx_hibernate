package simonadimitrova.electricitycompany.model.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Table(name = "client_price")
public class ClientPrice {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_type", nullable = false, unique = true)
    private Client.Type clientType;

    @DecimalMin(value = "0.001", message = "price value must be greater than zero")
    @Column(name = "value", nullable = false)
    private BigDecimal value; // per KWh

    public ClientPrice() {
    }

    public ClientPrice(Client.Type clientType, BigDecimal value) {
        this.clientType = clientType;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client.Type getClientType() {
        return clientType;
    }

    public void setClientType(Client.Type clientType) {
        this.clientType = clientType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
