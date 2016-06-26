package com.software.bank.dao.h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.software.bank.controller.CreditController;
import com.software.bank.dao.ConnectionFactory;
import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.RepaymentTypeEnum;
import com.software.bank.service.model.Credit;
import com.software.bank.view.KeyMessage;

public class CreditDataBaseDao implements IDataBase {

	private static final String CREATE_QUERY = 
			"CREATE TABLE credit (contract_number VARCHAR(60), "
			+ "summa_credit DOUBLE, summa_debet DOUBLE, term INT, rate DOUBLE, repayment VARCHAR(20))";

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
		final String querySql = "INSERT INTO credit (contract_number, summa_credit, summa_debet, term, rate, repayment) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1, credit.getContractNumber());
				statement.setDouble(2, credit.getSummaCredit());
				statement.setDouble(3, credit.getSummaDebet());
				statement.setInt(4, credit.getTerm());
				statement.setDouble(5, credit.getRate());
				statement.setString(6, credit.getRepayment().toString());
				statement.executeUpdate();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
	}

	@Override
	public void addPayment(String contractNumber, double summa_debet) throws DaoException {
		final String querySql = "UPDATE credit SET summa_debet = summa_debet + ? WHERE contract_number = ?";

		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setDouble(1, summa_debet);
				statement.setString(2, contractNumber);
				statement.executeUpdate();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
	}

	@Override
	public Credit getCredit(String contractNumber) throws DaoException {
		final String querySql = "SELECT * FROM credit WHERE contract_number = ?";
		Credit credit = new Credit();
		try(Connection connection = ConnectionFactory.getConnection()) {								
			try (PreparedStatement statement = connection.prepareStatement(querySql)){
				statement.setString(1,contractNumber);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					credit.setContractNumber(rs.getString("contract_number"));
					credit.setSummaCredit(rs.getDouble("summa_credit"));
					credit.setSummaDebet(rs.getDouble("summa_debet"));
					credit.setTerm(rs.getInt("term"));
					credit.setRate(rs.getDouble("rate"));
					credit.setRepayment(RepaymentTypeEnum.valueOf(rs.getString("repayment")));
				}
				rs.close();
			} 
		} catch (SQLException e){
			throw new DaoException(e);
		} 
		return credit;
	}
}