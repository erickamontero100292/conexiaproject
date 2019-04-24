package com.conexia.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "invoices", schema = "conexia")
public class InvoicesEntity {
    private Integer idinvoice;
    private Integer idcustomer;
    private Integer idwaiter;
    private Integer idtable;
    private Date invoicedate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinvoice")
    public Integer getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(Integer idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Basic
    @Column(name = "idcustomer")
    public Integer getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Integer idcustomer) {
        this.idcustomer = idcustomer;
    }

    @Basic
    @Column(name = "idwaiter")
    public Integer getIdwaiter() {
        return idwaiter;
    }

    public void setIdwaiter(Integer idwaiter) {
        this.idwaiter = idwaiter;
    }

    @Basic
    @Column(name = "idtable")
    public Integer getIdtable() {
        return idtable;
    }

    public void setIdtable(Integer idtable) {
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
