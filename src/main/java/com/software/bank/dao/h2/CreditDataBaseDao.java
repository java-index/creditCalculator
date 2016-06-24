package com.software.bank.dao.h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.software.bank.dao.ConnectionFactory;
import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;

public class CreditDataBaseDao implements IDataBase {

	private static final String CREATE_QUERY = 
			"CREATE TABLE credit (contract_number VARCHAR(60), summa_credit BIGINT, summa_debet BIGINT, term INT, rate DOUBLE)";

	// Create table
	static {
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(CREATE_QUERY);
		} catch (SQLException e) {
			System.err.println("can not create table CREDIT");
			e.printStackTrace();
		}
	}

	@Override
	public void addCredit(String contractNumber, long summa_credit, int term, double rate) throws DaoException {
		final String querySql = "INSERT INTO credit (contract_number, summa_credit, summa_debet, term, rate) VALUES (?, ?, ?, ?, ?)";

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1, contractNumber);
				statement.setLong(2, summa_credit);
				statement.setLong(3, 0);
				statement.setInt(4, term);
				statement.setDouble(5, rate);
				statement.executeUpdate();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
	}

	@Override
	public void addPayment(String contractNumber, long summa_debet) throws DaoException {
		final String querySql = "UPDATE credit SET summa_debet = summa_debet + ? WHERE contract_number = ?";

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setLong(1, summa_debet);
				statement.setString(2, contractNumber);
				statement.executeUpdate();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
	}

	@Override
	public long getDebet(String contractNumber) throws DaoException {
		final String querySql = "SELECT summa_debet FROM credit WHERE contract_number = ?";
		long debet = -1;

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1,contractNumber);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					debet = rs.getLong(1);
				}
				rs.close();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
		return debet;
	}

	@Override
	public long getCredit(String contractNumber) throws DaoException {
		final String querySql = "SELECT summa_credit FROM credit WHERE contract_number = ?";
		long credit = -1;

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1,contractNumber);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					credit = rs.getLong(1);
				}
				rs.close();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
		return credit;
	}

	@Override
	public int getTerm(String contractNumber) throws DaoException {
		final String querySql = "SELECT term FROM credit WHERE contract_number = ?";
		int term = -1;

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1,contractNumber);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					term = rs.getInt(1);
				}
				rs.close();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
		return term;
	}

	@Override
	public double getRate(String contractNumber) throws DaoException {
		final String querySql = "SELECT rate FROM credit WHERE contract_number = ?";
		double rate = -1;

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1,contractNumber);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					rate = rs.getDouble(1);
				}
				rs.close();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
		return rate;
	}
}