package com.conexia.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "invoices", schema = "conexia", catalog = "")
public class InvoicesEntity {
    private int idinvoice;
    private int idcustomer;
    private int idwaiter;
    private int idtable;
    private Date invoicedate;

    @Id
    @Column(name = "idinvoice")
    public int getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(int idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Basic
    @Column(name = "idcustomer")
    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    @Basic
    @Column(name = "idwaiter")
    public int getIdwaiter() {
        return idwaiter;
    }

    public void setIdwaiter(int idwaiter) {
        this.idwaiter = idwaiter;
    }

    @Basic
    @Column(name = "idtable")
    public int getIdtable() {
        return idtable;
    }

    public void setIdtable(int idtable) {
        this.idtable = idtable;
    }

    @Basic
    @Column(name = "invoicedate")
    public Date getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(Date invoicedate) {
        this.invoicedate = invoicedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicesEntity that = (InvoicesEntity) o;
        return idinvoice == that.idinvoice &&
                idcustomer == that.idcustomer &&
                idwaiter == that.idwaiter &&
                idtable == that.idtable &&
                Objects.equals(invoicedate, that.invoicedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idinvoice, idcustomer, idwaiter, idtable, invoicedate);
    }
}
