package com.conexia.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "conexia", catalog = "")
public class CustomersEntity {
    private Integer idcustomer;
    private String name;
    private String surname;
    private String lastname;
    private String observations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    public Integer getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Integer idcustomer) {
        this.idcustomer = idcustomer;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "observations")
    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return idcustomer == that.idcustomer &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(observations, that.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcustomer, name, surname, lastname, observations);
    }
}
