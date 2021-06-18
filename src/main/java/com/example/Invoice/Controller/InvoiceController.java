package com.example.Invoice.Controller;
import com.example.Invoice.Repository.MessageRepository;
import com.example.Invoice.Model.City;
import com.example.Invoice.Model.Hotel;
import com.example.Invoice.Model.Invoice;
import com.example.Invoice.Model.Message;
import com.example.Invoice.Service.CityService;
import com.example.Invoice.Service.InvoiceService;
import com.example.Invoice.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
    @Autowired
    private final InvoiceService invoiceService;

    @Autowired
    private final CityService cityService;

    @Autowired

    private final MessageService messageService;

    private final MessageRepository messageRepository;




    public InvoiceController(InvoiceService invoiceService, CityService cityService, MessageService messageService, MessageRepository messageRepository) {
        this.invoiceService = invoiceService;
        this.cityService = cityService;
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }


    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping(value = "/invoices/{id}", produces = {"application/json"})
    public ResponseEntity<Object[]> getInvoiceById(@PathVariable(value = "id") Integer invoiceNo) {
        return new ResponseEntity<>(invoiceService.getInvoiceUsingId(invoiceNo), HttpStatus.OK);
    }

    @PostMapping(value = "/filtered_invoices1")
    public ResponseEntity<List<Invoice>> getFilteredInvoices(@RequestParam String cityName,
                                                             @RequestParam String hotelName) {
        List<Invoice> filteredInvoices = invoiceService.getFilteredInvoice(cityName, hotelName);
        return new ResponseEntity<>(filteredInvoices, HttpStatus.OK);

    }

    @PostMapping(value = "/filtered_invoices2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoice>> getFilteredInvoicesByDate(@RequestParam int startDate,
                                                                   @RequestParam int endDate) {
        List<Invoice> filteredInvoices = invoiceService.getFilteredInvoiceByDate(startDate, endDate);
        return new ResponseEntity<>(filteredInvoices, HttpStatus.OK);

    }

    @PostMapping(value = "/invoice-update/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoice> updateInvoiceStatus(@RequestParam Integer invoiceNo, @RequestParam String remark
    ) {
        invoiceService.updateStatusOfInvoice(invoiceNo, remark);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "/cities/{city}", produces = {"application/json"})
    public ResponseEntity<List<Hotel>> getHotelByCity(@PathVariable(value = "city") String city) {
        return new ResponseEntity<>(cityService.getHotelByCity(city), HttpStatus.OK);


    }



    @RequestMapping( value="/message",method=RequestMethod.POST)
    @ResponseBody
    Message showMessage(@RequestBody Message  message) {
        System.out.println(message);
        message.setDateTime();

        if (message.isUploadDocument()){
        String uploadFileLink = messageService.copyFiles();
        message.setDocumentFile(uploadFileLink);}

        messageService.save(message);
        return message;
    }

//Mapping 2 for message restart kro
//@CrossOrigin(origins = "http://localhost:4200")

    @RequestMapping( value="/allMessage",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<Message> > showAllMessage(@RequestBody Message  msg) {
        System.out.println("INVOICE NUMBER RESponse body");

        System.out.println(msg);
       messageService.getallMessage( msg.getInvoiceNumber());
        List<Message> messages = messageService.getallMessage( msg.getInvoiceNumber());
        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);

    }

    @RequestMapping( value="/acceptdoc",method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<String> approveDocumentFile(@RequestBody Message  mes) {


         messageService.approveDocument(mes.getMessageId());
        return new ResponseEntity<String>("Successfull", HttpStatus.OK);


    }




//    @GetMapping("/allMessage")
//    public ResponseEntity<List<Message>> getallMessage(@PathVariable(value = "isApprover") boolean isApprover, @PathVariable(value = "invoiceNumber")String invoiceNumber) {
//        List<Message> messages = messageService.getallMessage(isApprover, invoiceNumber);
//        return new ResponseEntity<>(messages, HttpStatus.OK);
//    }




    }





