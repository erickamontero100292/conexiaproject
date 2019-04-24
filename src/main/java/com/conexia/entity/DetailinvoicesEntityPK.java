package com.conexia.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DetailinvoicesEntityPK implements Serializable {
    private int iddetailinvoices;
    private int idinvoice;

    @Column(name = "iddetailinvoices")
    @Id
    public int getIddetailinvoices() {
        return iddetailinvoices;
    }

    public void setIddetailinvoices(int iddetailinvoices) {
        this.iddetailinvoices = iddetailinvoices;
    }

    @Column(name = "idinvoice")
    @Id
    public int getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(int idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailinvoicesEntityPK that = (DetailinvoicesEntityPK) o;
        return iddetailinvoices == that.iddetailinvoices &&
                idinvoice == that.idinvoice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddetailinvoices, idinvoice);
    }
}
