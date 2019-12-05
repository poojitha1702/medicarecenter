package com.cognizant.medicareservice.controller;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicareservice.model.Booking;
import com.cognizant.medicareservice.service.BookingService;





@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
                @Autowired
                BookingService bookingService;

                @PostMapping("/{patient}/{doctor}")
                public void addCart(@PathVariable String patient,@PathVariable String doctor) throws ParseException{
                	bookingService.bookAppointment(patient,doctor);
                }
                
                @GetMapping("/{doctorId}")
                public Booking getUnApprovedPatients(@PathVariable("doctorId") String doctorID ){
                                
                                Booking book=new Booking();           
                                book.setListone(bookingService.getAllBookings(doctorID));
                                
                               
                                return book;
                }
                
                
                @GetMapping("/doctorapproved/{doctorId}")
                public Booking getApprovedPatients(@PathVariable("doctorId") String doctorID ){
                                System.err.println("LAISUFIJUD");
                                Booking book=new Booking();           
                                book.setListone(bookingService.getApprovedPatients(doctorID));
                                
                                
                                return book;
                }


                
}
