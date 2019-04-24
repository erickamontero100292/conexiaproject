package com.conexia.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tables", schema = "conexia", catalog = "")
public class TablesEntity {
    private int idtable;
    private int maxdiners;
    private String location;

    @Id
    @Column(name = "idtable")
    public int getIdtable() {
        return idtable;
    }

    public void setIdtable(int idtable) {
        this.idtable = idtable;
    }

    @Basic
    @Column(name = "maxdiners")
    public int getMaxdiners() {
        return maxdiners;
    }

    public void setMaxdiners(int maxdiners) {
        this.maxdiners = maxdiners;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablesEntity that = (TablesEntity) o;
        return idtable == that.idtable &&
                maxdiners == that.maxdiners &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtable, maxdiners, location);
    }
}
