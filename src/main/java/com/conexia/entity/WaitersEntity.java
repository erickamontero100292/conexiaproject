package com.conexia.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "waiters", schema = "conexia", catalog = "")
public class WaitersEntity {
    private int idwaiter;
    private String name;
    private String surname;
    private String lastname;

    @Id
    @Column(name = "idwaiter")
    public int getIdwaiter() {
        return idwaiter;
    }

    public void setIdwaiter(int idwaiter) {
        this.idwaiter = idwaiter;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaitersEntity that = (WaitersEntity) o;
        return idwaiter == that.idwaiter &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idwaiter, name, surname, lastname);
    }
}
