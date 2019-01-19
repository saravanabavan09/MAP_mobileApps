package com.cg.map.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.map.dao.MapDao;
import com.cg.map.dao.MapDaoImpl;
import com.cg.map.exception.MAPException;
import com.cg.map.model.Mobile;

public class MapServiceImpl implements MapService {
	List<String> list = new ArrayList<>();
	MapDao mapDao = new MapDaoImpl();

	@Override
	public boolean validateFields(Mobile mobile) throws MAPException {
		boolean validateFlag = false;
		if (!checkName(mobile.getCustomerName())) {
			list.add(
					"The name should valid and should contain maximum 20 alphabets and first letter should be captial letter\n");
		}

		if (!checkMailId(mobile.getMailId())) {
			list.add("MailId should be valid");
		}
		if (!checkMobilenumber(mobile.getMobileNumber())) {
			list.add("Phone number should starts with the exactly 10 digits and should start with 6|7|8|9\\n");
		}
		if (!checkMobileId(mobile.getMobileId())) {
			list.add("MobileId should contains only 4 digits");
		}
		if (!list.isEmpty()) {
			throw new MAPException(list + "");
		} else {
			validateFlag = true;
		}
		// TODO Auto-generated method stub
		return validateFlag;
	}

	private boolean checkMobileId(int mobileId) {
		String MobileIdRegEx = "[0-9]{4}$";
		return Pattern.matches(MobileIdRegEx, String.valueOf(mobileId));
	}

	private boolean checkMobilenumber( String mobileNumber) {
		String MobileNumberRegEx = "[6|7|8|9]{1}[0-9]{9}$";
		return Pattern.matches(MobileNumberRegEx, String.valueOf(mobileNumber));
	}

	private boolean checkMailId(String mailId) {
		String MailIdRegEx = "[a-zA-Z0-9._]*@[A-Za-z]*\\.[a-zA-z]*$";
		return Pattern.matches(MailIdRegEx, mailId);
	}

	private boolean checkName(String customerName) {
		String CustomerNameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(CustomerNameRegEx, customerName);

	}

	@Override
	public int addCustomerDetails(Mobile mobile) throws MAPException {
		return mapDao.addCustomerDetails(mobile);
	}

	@Override
	public List<Mobile> getMobiles() throws MAPException {
		// TODO Auto-generated method stub
		return mapDao.getMobiles();
	}

	@Override
	public int deleteDetails(int idForDelete) throws MAPException {
		// TODO Auto-generated method stub
		return mapDao.deleteDetails(idForDelete);
	}

	@Override
	public List<Mobile> searchDetails(Mobile mobile2) throws MAPException {
		// TODO Auto-generated method stub
		return mapDao.searchDetails(mobile2);
	}

}
