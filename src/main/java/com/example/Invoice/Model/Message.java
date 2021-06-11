package com.example.Invoice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "MESSAGE_MASTER")
public class Message implements Serializable {
    @Column(nullable = false, updatable = false, name = "invoiceNumber")
    @Id
    private int invoiceNumber;
    @Column(name = "dateTime")
    private Timestamp dateTime;
    @Column(name = "isApprover")
    private Boolean isApprover;
    @Column(name = "chatMessage")
    private String chatMessage;


    public Message(int invoiceNumber, Timestamp dateTime, Boolean isApprover, String chatMessage) {
        this.invoiceNumber = invoiceNumber;
        this.dateTime = dateTime;
        this.isApprover = isApprover;
        this.chatMessage = chatMessage;
    }

    public Message() {

    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public Boolean getApprover() {
        return isApprover;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public void setApprover(Boolean approver) {
        isApprover = approver;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }
}





//    @Override
//    public String toString() {
//        return "Invoice{" +
//                "invoiceNo=" + invoiceNo +
//                ", invoiceDate='" + invoiceDate + '\'' +
//                ", travelReqNo=" + travelReqNo +
//                ", guestName='" + guestName + '\'' +
//                ", roomType='" + roomType + '\'' +
//                ", stayDuration='" + stayDuration + '\'' +
//                ", tcsCost=" + tcsCost +
//                ", invoiceStatus='" + invoiceStatus + '\'' +
//                ", swonNumber=" + swonNumber +
//                ", bookingId=" + bookingId +
//                ", generatedDate=" + generatedDate +
//                ", remark='" + remark + '\'' +
//                '}';
//    }
//}



