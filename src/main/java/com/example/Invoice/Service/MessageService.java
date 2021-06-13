package com.example.Invoice.Service;

import com.example.Invoice.Model.Invoice;
import com.example.Invoice.Model.Message;
import com.example.Invoice.Model.Message.*;

import com.example.Invoice.Repository.InvoiceRepository;
import com.example.Invoice.Repository.MessageRepository;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;


import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;


    public List<Message> getallMessage(Boolean isApprover, String clickingValue) {
        return messageRepository.getallMessage(isApprover,clickingValue);
    }

    public void save(Message message){
        messageRepository.save(message);
    }

    public String copyFiles(){
        try{

            String path = "D:/Upload/";
            File pathfolder = new File(path);
            System.out.println("copied");
            File[] listOfFiles = pathfolder.listFiles();
            String filename = listOfFiles[0].getName();

            File src = new File(path+filename);
        File dest = new File("D:/cloud/" + java.util.UUID.randomUUID().toString() + ".pdf");
        FileSystemUtils.copyRecursively(src, dest);
        src.delete();
         return   dest.getAbsolutePath();

    }
        catch(IOException ie) {
            ie.printStackTrace();
        }
    return "False";
    }

//    public Object[] getInvoiceUsingId(Integer id) {
//
//        return invoiceRepository.getInvoiceById(id);
//    }

//    public List<Invoice> getFilteredInvoice(String cityName, String hotelName) {
//        return invoiceRepository.findByCityAndHotel(cityName, hotelName);
//    }
//
//    public List<Invoice> getFilteredInvoiceByDate(int startDate, int endDate) {
//        return invoiceRepository.findByStartDateAndEndDate(startDate, endDate);
//    }
//
//    public void updateStatusOfInvoice(Integer invoiceId,String remark) {
//        Invoice invoice = invoiceRepository.getById(invoiceId);
//        invoice.setInvoiceStatus("approved");
//        invoice.setRemark(remark);
//        invoiceRepository.save(invoice);
//    }










}
