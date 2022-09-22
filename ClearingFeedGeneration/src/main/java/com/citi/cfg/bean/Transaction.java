package com.citi.cfg.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
	String url = "jdbc:mysql://localhost:3306/dbr";
	String User = "root";
	String Pass = "Gouri_1234";
	private String transactionRef;
	private String valueDate;
	private String payerName;
	private String payerAccount;
	private String payeeName;
	private String payeeAccount;
	private float amount;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionRef, String valueDate, String payerName, String payerAccount, String payeeName,
			String payeeAccount, float amount) {
		super();
		this.transactionRef = transactionRef;
		this.valueDate = valueDate;
		this.payerName = payerName;
		this.payerAccount = payerAccount;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
		this.amount = amount;

	}

	public String getTransactionRef() {
		return transactionRef;
	}

	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;

	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void datbasefun() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, User, Pass);
		System.out.println("database");
		String query = "insert into main_table (transactionRef,valueDate,payerName,payerAccount ,payeeName, payeeAccount,amount,status)"
				+ "Values(?,?,?,?,?,?,?,?)";
		PreparedStatement p_stat;
		p_stat = conn.prepareStatement(query);
		p_stat.setString(1, transactionRef);
		p_stat.setString(2, valueDate);
		p_stat.setString(3, payerName);
		p_stat.setString(4, payerAccount);
		p_stat.setString(5, payeeName);
		p_stat.setString(6, payeeAccount);
		p_stat.setFloat(7, amount);
		String status = "Successfull";
		if (status_of_transaction() == false) {
			status = "failed";
		}
		p_stat.setString(8, status);
		p_stat.execute();
	}

	public boolean status_of_transaction() {
		validation v = new validation();

		boolean check_transactonRef = false;
		boolean check_valuedate = false;
		boolean check_payeraccount = false;
		boolean check_payerName = false;
		boolean check_payeeAccount = false;
		boolean check_payeeName = false;
		boolean check_amount = false;
		check_transactonRef = v.checkAlphanumericString(transactionRef, 12);
		int day = Integer.parseInt(valueDate.substring(0, 2));
		int month = Integer.parseInt(valueDate.substring(2, 4));
		int year = Integer.parseInt(valueDate.substring(4, 8));
		check_valuedate = v.checkDay(day, month, year);
		check_payeraccount = v.checkAlphanumericString(payerAccount, 12);
		check_payerName = v.checkAlphanumericString(payerName, 35);
		check_payeeAccount = v.checkAlphanumericString(payeeAccount, 12);
		check_payeeName = v.checkAlphanumericString(payeeName, 35);
		check_amount = v.checkAmount(amount);

		if (check_transactonRef == false || check_valuedate == false || check_payeraccount == false
				|| check_payeraccount == false || check_payerName == false || check_payeeAccount == false
				|| check_payeeName == false || check_amount == false) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		// status_of_transaction();
		try {
			datbasefun();
		} catch (SQLException e) {

		}
		return "transaction [transactionRef=" + transactionRef + ", valueDate=" + valueDate + ", payerName=" + payerName
				+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
				+ ", amount=" + amount + "]";
	}
}