package com.citi.cfg.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="main_table")
public class Transaction {

	@Id
	private String transactionRef;
	private String valueDate;
	private String payerName;
	private String payerAccount;
	private String payeeName;
	private String payeeAccount;
	private float amount;
	private String status;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
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

//	@Override
//	public String toString() {
//		// status_of_transaction();
//		try {
////			datbasefun();
////		} catch (SQLException e) {
//
//		}
//		return "transaction [transactionRef=" + transactionRef + ", valueDate=" + valueDate + ", payerName=" + payerName
//				+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
//				+ ", amount=" + amount + "]";
//	}
}