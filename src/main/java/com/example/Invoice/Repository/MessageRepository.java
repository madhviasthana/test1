package com.example.Invoice.Repository;

import com.example.Invoice.Model.Invoice;
import com.example.Invoice.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT * FROM (" +
            "    SELECT * FROM message_master" +
            "    ORDER BY dateTime ASC" +
            ") AS sub" +
            "GROUP BY invoiceNumber", nativeQuery = true)
    List<Message> getallMessage(Boolean isApprover, String clickingValue);


//    @Query(value = "select i.invoice_number,i.booking_id,i.guest_name,i.invoice_date,i.invoice_status," +
//            "i.room_type,i.stay_duration,i.swan_number,i.tcs_cost,i.travel_request_number,i.generated_date,i.remark " +
//            "from invoice_master as i where i.generated_date >=:startDate and i.generated_date<=:endDate",
//            nativeQuery = true)
//    List<Invoice> findByStartDateAndEndDate(int startDate, int endDate);


//        @Query(value = "select i.chatMessage"+
//            "where i.invoice_number!='invoiceNumber'", nativeQuery = true)
//    List<Message> getAllMessage();

//    @Query(value = "SELECT * FROM (SELECT * ORDER BY date ASC, time ASC LIMIT 18446744073709551615) AS sub GROUP BY sub.name")






}


