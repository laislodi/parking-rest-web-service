package com.webservices.start.persistence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CLIENT", unique = true, nullable = false)
    private Long idClient;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 15)
    private String telephone;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client") // atribudo da classe vehicle
    @JsonManagedReference
    private List<Vehicle> vehicleList;

    public Client() {
    }

    public Client(Long idClient, String name, String cpf, String telephone, List<Vehicle> vehicleList) {
        this.idClient = idClient;
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.vehicleList = vehicleList;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(idClient, client.idClient) &&
                Objects.equals(name, client.name) &&
                Objects.equals(cpf, client.cpf) &&
                Objects.equals(telephone, client.telephone) &&
                Objects.equals(vehicleList, client.vehicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, name, cpf, telephone, vehicleList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telephone='" + telephone + '\'' +
                ", vehicleList=" + vehicleList +
                '}';
    }
}
