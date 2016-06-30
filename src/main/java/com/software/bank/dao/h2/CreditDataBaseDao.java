package com.software.bank.dao.h2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.software.bank.dao.ConnectionFactory;
import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.Repayment;
import com.software.bank.service.model.Credit;

public class CreditDataBaseDao implements IDataBase {
	
	private static final String CREATE_QUERY = 
			"CREATE TABLE credit (contract_number VARCHAR(60), "
			+ "total_credit DECIMAL, total_debet DECIMAL, term INT, rate DECIMAL, qty_payments INT, repayment VARCHAR(10))";
	// Create table
	static {
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(CREATE_QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCredit(Credit credit) throws DaoException {
		final String querySql = "INSERT INTO credit (contract_number, total_credit, total_debet, term, rate, qty_payments, repayment) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				int i = 1;
				statement.setString(i++, credit.getContractNumber());
				statement.setBigDecimal(i++, credit.getTotalCredit());
				statement.setBigDecimal(i++, new BigDecimal("0.0"));
				statement.setInt(i++, credit.getTerm());
				statement.setBigDecimal(i++, credit.getRate());
				statement.setInt(i++, 0);
				statement.setString(i++, credit.getRepayment().toString());
				statement.executeUpdate();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
	}

	@Override
	public void addPayment(String contractNumber, BigDecimal total_debet) throws DaoException {
		final String querySql = "UPDATE credit SET total_debet = ?, qty_payments = qty_payments + 1  WHERE contract_number = ?";
		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				int i = 1;
				statement.setBigDecimal(i++, total_debet);
				statement.setString(i++, contractNumber);
				statement.executeUpdate();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
	}

	@Override
	public Credit getCredit(String contractNumber) throws DaoException {
		final String querySql = "SELECT * FROM credit WHERE contract_number = ?";
		Credit credit = null;
		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1, contractNumber);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					credit = new Credit();
					credit.setContractNumber(rs.getString("contract_number"));
					credit.setTotalCredit(rs.getBigDecimal("total_credit"));
					credit.setTotalDebit(rs.getBigDecimal("total_debet"));
					credit.setTerm(rs.getInt("term"));
					credit.setRate(rs.getBigDecimal("rate"));
					credit.setQtyPayments(rs.getInt("qty_payments"));
					credit.setRepayment(Repayment.valueOf(rs.getString("repayment")));
				}
				rs.close();
			} 
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new DaoException(e);
		} 
		return credit;
	}
}