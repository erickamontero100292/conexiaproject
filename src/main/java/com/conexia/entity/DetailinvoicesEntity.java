package com.conexia.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detailinvoices", schema = "conexia", catalog = "")
@IdClass(DetailinvoicesEntityPK.class)
public class DetailinvoicesEntity {
    private int iddetailinvoices;
    private int idinvoice;
    private int idcook;
    private String plate;
    private double importe;

    @Id
    @Column(name = "iddetailinvoices")
    public int getIddetailinvoices() {
        return iddetailinvoices;
    }

    public void setIddetailinvoices(int iddetailinvoices) {
        this.iddetailinvoices = iddetailinvoices;
    }

    @Id
    @Column(name = "idinvoice")
    public int getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(int idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Basic
    @Column(name = "idcook")
    public int getIdcook() {
        return idcook;
    }

    public void setIdcook(int idcook) {
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
    public int hashCode() {
        return Objects.hash(iddetailinvoices, idinvoice, idcook, plate, importe);
    }
}
