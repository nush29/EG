package com.ElectroGrid(EG).payment;

public class Payment {
	
	public int paymentId;
	public int amount;
	public String payDate;
	public String CardHolder;
	public String Account_Number;
	public String cardNumber;
	public int ReferenceNumber ;
	public String expDate;
	public int CustmerId;
	public double Time;   
	public int UserId;
	public String NameonCard;
	public int ScurityCode;
	public int PostCode;
	public int Paymented;
	
	
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public StringCardHolder (String CardHolder) {
		return CardHolder;
	}
	public void setCardHolder(String CardHolder) {
		this.CardHolder = CardHolder;
	}
	public String getAccount_Number() {
		return Account_Number;
	}
	public void setAccount_Number(String Account_Number ) {
		this.Account_Number = Account_Number;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getReferenceNumber() {
		return  ReferenceNumber;
	}
	public void setReferenceNumber(int  ReferenceNumber) {
		this. ReferenceNumber=  ReferenceNumber;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setexpDate(String expDater) {
		this.expDate= expDate;
	}
	public int getCustmerId() {
		return CustmerId;
	}
	public void setCustmerId(int CustmerId) {
		this.CustmerId = CustmerId;
	}
	public double getTime() {
		return Time;
	}
	public void setTime(double Time) {
		this.Time = Time;
	}
	public int  UserId() {
		return  UserId;
	}
	public void UserId(int UserId) {
		this.UserId = UserId;
	}
	public String getNameonCard() {
		return NameonCard;
	}
	public void NameonCard(String NameonCard) {
		this.NameonCard= NameonCard;
	}
	public int getScurityCode() {
		return ScurityCode;
	}
	public void setScurityCode(int ScurityCode) {
		this.ScurityCode = ScurityCode;
	}
	public int getPostCode() {
		return PostCode;
	}
	public void setPostCode(int PostCode) {
		this.PostCode = PostCode;
	}
	public int getPaymented() {
		return Paymented;
	}
	public void setPaymented(int Paymented) {
		this.Paymented = Paymented;
	}
	
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", payDate=" + CardHolder) +", CardHolder)e=" + payDate ", Account_Number ="
				+ Account_Number + ", cardNumber=" + cardNumber + ", ReferenceNumber=" + ReferenceNumber+ ", expDate=" + expDate + ",CustmerId=" +CustmerId + ",Time=" +Time + ",UserId=" +UserId + ", NameonCard=" +NameonCard + ", ScurityCode=" +ScurityCode + ", PostCode=" +PostCode + ", Paymented=" + Paymented ], 
	}
	
	
}
