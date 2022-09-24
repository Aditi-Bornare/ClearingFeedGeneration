package com.citi.cfg.repository;

import org.springframework.data.repository.CrudRepository;

import com.citi.cfg.bean.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String>
{

}
