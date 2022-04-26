package com.service.billmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.billmanagement.model.Bill;
import com.service.billmanagement.repo.BillRepo;


@RestController
@RequestMapping("/bill-service")
public class BillController {

	@Autowired
	BillRepo billRepo;
	
	@PostMapping("/save")
	public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String formattedDate = sdf.format(date);
			bill.setDate(formattedDate);
			System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
			Bill bills=billRepo.save(bill);
			return new ResponseEntity<>(bills,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find")
	 public List<Bill> getAllBill(){
		 return billRepo.findAll();
	 }
	 
	 @GetMapping("/billing/{id}")
	  public ResponseEntity<Bill> getBillById(@PathVariable("id") Integer id) {
	    Optional<Bill> billData = billRepo.findById(id);
	    if (billData.isPresent()) {
	      return new ResponseEntity<>(billData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @DeleteMapping("/del-bill/{id}")
	  public ResponseEntity<HttpStatus> deletebill(@PathVariable("id") Integer id) {
	    try {
	      billRepo.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/update-bill/{id}")
	  public ResponseEntity<Bill> updateBill(@PathVariable("id") Integer id, @RequestBody Bill bill) {
	    Optional<Bill> billData = billRepo.findById(id);
	    if (billData.isPresent()) {
	    	Bill bill2=billRepo.save(bill);
			return new ResponseEntity<>(bill2,HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
