package com.cg.map.dao;

public interface QueryMapper {
	public static final String insertCustomerDetails = "insert into purchasedetails values(purchase_seq.nextval,?,?,?,sysdate,?)";
	public static final String getDetailsQuery ="select * from mobiles";
	public static final String deleteQuery = "delete from mobiles where mobileid=?";
	public static final String selectQueryBasedOnPrice = "select * from mobiles where price between ? and ?";
}
