package com.example.Invoice.Model;

import javax.persistence.*;

@Entity
@Table(name = "BILLING_TBL")
public class BillingDetails {
    @Id
    private int invoiceId;
    private String billingAddress;
    private float amount;
    private float cGST;
    private float sGST;
    private String billingInstruction;

    public BillingDetails(int invoiceId, String billingAddress, float amount, float cGST, float sGST, String billingInstruction) {
        this.invoiceId = invoiceId;
        this.billingAddress = billingAddress;
        this.amount = amount;
        this.cGST = cGST;
        this.sGST = sGST;
        this.billingInstruction = billingInstruction;
    }
    public BillingDetails()
    {

    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getcGST() {
        return cGST;
    }

    public void setcGST(float cGST) {
        this.cGST = cGST;
    }

    public float getsGST() {
        return sGST;
    }

    public void setsGST(float sGST) {
        this.sGST = sGST;
    }

    public String getBillingInstruction() {
        return billingInstruction;
    }

    public void setBillingInstruction(String billingInstruction) {
        this.billingInstruction = billingInstruction;
    }

    @Override
    public String toString() {
        return "BillingDetails{" +
                "invoiceId=" + invoiceId +
                ", billingAddress='" + billingAddress + '\'' +
                ", amount=" + amount +
                ", cGST=" + cGST +
                ", sGST=" + sGST +
                ", billingInstruction='" + billingInstruction + '\'' +
                '}';
    }
}

