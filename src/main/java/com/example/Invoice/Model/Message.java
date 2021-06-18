package com.example.Invoice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;




@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "MESSAGE_MASTER", schema="public")
public class Message implements Serializable {

    @Transient
    private boolean uploadDocument;



    @Column(name="messageId")
    @Id @GeneratedValue()
    private int messageId;


    @Column( name = "invoiceNumber")
    private int invoiceNumber;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @Column(name = "isApprover")
    @JsonProperty("isApprover")
    private boolean isApprover;

    @Column(name = "isApproved")
    @JsonProperty("isApproved")
    private boolean isApproved;

    @Column(name = "chatMessage")
    private String chatMessage;
    @Column(name = "documentFile")
    private String documentFile;

    public Message(int invoiceNumber,LocalDateTime dateTime, boolean isApprover, String chatMessage,String documentFile,boolean uploadDocument) {
        this.invoiceNumber = invoiceNumber;
        this.dateTime = dateTime;
        this.isApprover = isApprover;
        this.chatMessage = chatMessage;
        this.documentFile=documentFile;
        this.uploadDocument =uploadDocument;

    }

    public Message() {

    }

    public boolean isApproved() {
        return isApproved;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setDocumentFile(String documentFile) {
        this.documentFile = documentFile;
    }

    public String getDocumentFile() {
        return documentFile;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean getApprover() {
        return isApprover;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public boolean isUploadDocument() {
        return uploadDocument;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setDateTime() {

        this.dateTime = LocalDateTime.now();}


    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    @Override
    public String toString() {
        return "Message{" +
                "invoiceNumber=" + invoiceNumber +
                ", dateTime=" + dateTime +
                ", isApprover=" + isApprover +
                ", chatMessage='" + chatMessage + '\'' +
                '}';
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
//




