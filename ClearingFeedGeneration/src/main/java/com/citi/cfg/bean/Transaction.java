package com.citi.cfg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction 
{
	private long transactionRef;
	private String valDate;
	private String payerName;
	private String payerAccount;
	private String payeeName;
	private String payeeAccount;
	private float amount;
}
