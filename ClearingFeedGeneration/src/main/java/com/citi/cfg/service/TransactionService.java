package com.citi.cfg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.cfg.bean.Transaction;
import com.citi.cfg.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	public void addTransaction(Transaction transaction)
	{
		transactionRepository.save(transaction);
	}
	
	public List<Transaction> getAllTransactions()
	{
		List<Transaction> transactions= new ArrayList<Transaction>();
		List<Transaction> failedTransactions= new ArrayList<Transaction>();
		transactionRepository.findAll().forEach(transactions::add);
		for(Transaction t:transactions) {
			if(t.getStatus().equals("Failed"))
			{
				failedTransactions.add(t);
			}
		}
		return failedTransactions;
	}
}
