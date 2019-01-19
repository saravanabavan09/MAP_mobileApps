package com.cg.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.map.exception.MAPException;
import com.cg.map.model.Mobile;
import com.cg.map.utility.JDBCUtility;

public class MapDaoImpl implements MapDao {
	Connection connection = null;

	PreparedStatement statement = null;
	ResultSet resultSet = null;
	static Logger logger = Logger.getLogger(MapDaoImpl.class);

	@Override
	public int addCustomerDetails(Mobile mobile) throws MAPException {
		logger.info("in add Customer method");
		/**
		 * method               : addCustomerDetails 
		 * argument             : it's taking model object as an
		 * argument return type : this method return the generated id to the user 
		 * Author               : Capgemini 
		 * Date                 : 16 - Jan - 2019
		 * 
		 **/

		connection = JDBCUtility.getConnection();
		logger.info("connection object created");
		
		/*String str=String.valueOf(mobile.getMobileNumber());*/
		int generatedId=0;
		System.err.println(mobile.getCustomerName());
		System.err.println(mobile.getMailId());
		System.err.println(mobile.getMobileNumber());
		System.err.println(mobile.getMobileId());
				
		
		try {
			
			statement = connection.prepareStatement(QueryMapper.insertCustomerDetails);
			logger.debug("statement object created");
			statement.setString(1, mobile.getCustomerName());
			statement.setString(2, mobile.getMailId());
			statement.setString(3, mobile.getMobileNumber());
			statement.setInt(4, mobile.getMobileId());
			generatedId = statement.executeUpdate();
			System.out.println(generatedId);
			logger.info("execute update called");

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new MAPException("problem occured while creating the statement object");
		}
		return generatedId;
	}

	@Override
	public List<Mobile> getMobiles() throws MAPException {
		List<Mobile> list = new ArrayList<>();
		connection = JDBCUtility.getConnection();

		try {
			statement = connection.prepareStatement(QueryMapper.getDetailsQuery);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String mobile = resultSet.getString(2);
				Double price = resultSet.getDouble(3);
				int quantity = resultSet.getInt(4);

				Mobile labModel = new Mobile();
				labModel.setMobileId(id);
				labModel.setPhoneName(mobile);
				labModel.setPrice(price);
				labModel.setQuantity(quantity);

				list.add(labModel);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteDetails(int idForDelete) throws MAPException {
		connection = JDBCUtility.getConnection();
		int result = 0;
		try {

			statement = connection.prepareStatement(QueryMapper.deleteQuery);

			statement.setInt(1, idForDelete);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			throw new MAPException("Statement was not created");
		}
		try {
			statement.close();
		} catch (SQLException e) {
			throw new MAPException("Statement was not closed");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			throw new MAPException("Connection was not closed");
		}
		return result;
	}

	@Override
	public List<Mobile> searchDetails(Mobile mobile2) throws MAPException {
		connection = JDBCUtility.getConnection();
		List<Mobile> list = new ArrayList<>();
		try {
			statement = connection.prepareStatement(QueryMapper.selectQueryBasedOnPrice);
			statement.setDouble(1, mobile2.getMinprice());
			statement.setDouble(2, mobile2.getMaxprice());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String mobile = resultSet.getString(2);
				Double price = resultSet.getDouble(3);
				int quantity = resultSet.getInt(4);

				Mobile mobile1 = new Mobile();
				mobile1.setMobileId(id);
				mobile1.setPhoneName(mobile);
				mobile1.setPrice(price);
				mobile1.setQuantity(quantity);

				list.add(mobile1);
			}
		} catch (SQLException e) {
			throw new MAPException("Statement was not created");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new MAPException("ResultSet was not closed");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MAPException("Statement was not closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new MAPException("Connection was not closed");
			}

		}
		return list;
	}

}
