/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonadimitrova.electricitycompany.model.entities;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author nimer
 */
@Entity
@Table(name = "client")
public class Client {

    public enum Type {
        PRIVATE,
        COMPANY,
    }

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern.List({
        @Pattern(regexp = "$[A-Z]", message = "Name must start with a capital letter"),
        @Pattern(regexp = "$[A-Za-z0-9 ]+", message = "Name can contain only letters, numbers and spaces"),})
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "client_type", nullable = false)
    private Type clientType;

    @OneToMany(mappedBy = "client")
    private List<ClientMeasurement> measurements;
}
