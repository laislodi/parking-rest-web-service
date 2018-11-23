package com.webservices.start.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false, length = 10)
    private String placa;
    @Column(nullable = false, length = 20)
    private String model;
    @Column(nullable = false, length = 20)
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    private Client client;



    public Vehicle() {
    }

    public Vehicle(Long id, String placa, String model, String color, Client client) {
        this.id = id;
        this.placa = placa;
        this.model = model;
        this.color = color;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) &&
                Objects.equals(placa, vehicle.placa) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(client, vehicle.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa, model, color, client);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", client=" + client +
                '}';
    }
}
