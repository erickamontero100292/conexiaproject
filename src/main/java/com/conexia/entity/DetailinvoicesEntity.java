package com.conexia.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "detailinvoices", schema = "conexia")

public class DetailinvoicesEntity implements Serializable {
    private Integer iddetailinvoices;
    private Integer idinvoice;
    private Integer idcook;
    private String plate;
    private double importe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetailinvoices")
    public Integer getIddetailinvoices() {
        return iddetailinvoices;
    }

    public void setIddetailinvoices(Integer iddetailinvoices) {
        this.iddetailinvoices = iddetailinvoices;
    }


    @Column(name = "idinvoice")
    public Integer getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(Integer idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Basic
    @Column(name = "idcook")
    public Integer getIdcook() {
        return idcook;
    }

    public void setIdcook(Integer idcook) {
        this.idcook = idcook;
    }

    @Basic
    @Column(name = "plate")
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Basic
    @Column(name = "importe")
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailinvoicesEntity that = (DetailinvoicesEntity) o;
        return iddetailinvoices == that.iddetailinvoices &&
                idinvoice == that.idinvoice &&
                idcook == that.idcook &&
                Double.compare(that.importe, importe) == 0 &&
                Objects.equals(plate, that.plate);
    }

    @Override
    public Integer hashCode() {
        return Objects.hash(iddetailinvoices, idinvoice, idcook, plate, importe);
    }
}
