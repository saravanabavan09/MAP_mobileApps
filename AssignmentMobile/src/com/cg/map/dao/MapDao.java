package com.cg.map.dao;

import java.util.List;

import com.cg.map.exception.MAPException;
import com.cg.map.model.Mobile;

public interface MapDao {

	int addCustomerDetails(Mobile mobile) throws MAPException;

	List<Mobile> getMobiles()throws MAPException;

	int deleteDetails(int idForDelete)throws MAPException;

	List<Mobile> searchDetails(Mobile mobile2)throws MAPException;

}
