package com.cg.map.model;

import java.util.Date;

public class Mobile {
	private String customerName;
	private String mailId;
	private String mobileNumber;
	private int mobileId;
	private Date purchaseDate;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	private String phoneName;
	private Double price;
	private int quantity;

	@Override
	public String toString() {
		return "Mobile [customerName=" + customerName + ", mailId=" + mailId + ", mobileNumber=" + mobileNumber
				+ ", mobileId=" + mobileId + ", purchaseDate=" + purchaseDate + ", phoneName=" + phoneName + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Mobile(String customerName, String mailId, String mobileNumber, int mobileId, Date purchaseDate,
			String phoneName, Double price, int quantity) {
		super();
		this.customerName = customerName;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
		this.mobileId = mobileId;
		this.purchaseDate = purchaseDate;
		this.phoneName = phoneName;
		this.price = price;
		this.quantity = quantity;
	}

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	private Double minprice;
	private Double maxprice;

	public Double getMinprice() {
		return minprice;
	}

	public void setMinprice(Double minprice) {
		this.minprice = minprice;
	}

	public Double getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(Double maxprice) {
		this.maxprice = maxprice;
	}

	public Mobile(Double minprice, Double maxprice) {
		super();
		this.minprice = minprice;
		this.maxprice = maxprice;
	}

}
