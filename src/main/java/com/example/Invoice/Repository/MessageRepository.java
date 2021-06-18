package com.example.Invoice.Repository;
import com.example.Invoice.Model.Invoice;
import com.example.Invoice.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {


    @Query(value = "select  m.chat_message,m.message_id,m.is_approved, m.date_time,m.message_id,m.document_file,m.invoice_number,m.is_approver from message_master as m where m.invoice_number=:invoicenum order by m.date_time asc",
            nativeQuery = true)
    List<Message> getallMessage(Integer invoicenum);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.message_master SET  is_approved=true WHERE message_id=:msgId",
            nativeQuery = true)
    void approveDocument(Integer msgId);



//    Object[]  getallMessage(int invoicenum);


//    SELECT  chat_message, date_time
//    FROM public.message_master where invoice_ order by date_time asc


}
