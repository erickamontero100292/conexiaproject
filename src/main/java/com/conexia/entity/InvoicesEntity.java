package com.conexia.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "invoices", schema = "conexia")
public class InvoicesEntity {
    private Long idinvoice;
    private Long idcustomer;
    private Long idwaiter;
    private Long idtable;
    private Date invoicedate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinvoice")
    public Long getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(Long idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Basic
    @Column(name = "idcustomer")
    public Long getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Long idcustomer) {
        this.idcustomer = idcustomer;
    }

    @Basic
    @Column(name = "idwaiter")
    public Long getIdwaiter() {
        return idwaiter;
    }

    public void setIdwaiter(Long idwaiter) {
        this.idwaiter = idwaiter;
    }

    @Basic
    @Column(name = "idtable")
    public Long getIdtable() {
        return idtable;
    }

    public void setIdtable(Long idtable) {
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
