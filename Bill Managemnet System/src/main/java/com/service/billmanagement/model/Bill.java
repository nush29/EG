package com.service.billmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill_tbl")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String billNo;
	private String accNo;
	private String billDate;
	private Double amount;
	private String description;
	

	public Bill() {
		
		// TODO Auto-generated constructor stub
	}
	public Bill(int id, String billNo, String accNo, String date, Double amount, String description) {
		super();
		this.id = id;
		this.billNo = billNo;
		this.accNo = accNo;
		billDate = date;
		this.amount = amount;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getDate() {
		return billDate;
	}
	public void setDate(String date) {
		billDate = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", billNo=" + billNo + ", accNo=" + accNo + ", Date=" + billDate + ", amount=" + amount
				+ ", description=" + description + "]";
	}
	

	
	
}
