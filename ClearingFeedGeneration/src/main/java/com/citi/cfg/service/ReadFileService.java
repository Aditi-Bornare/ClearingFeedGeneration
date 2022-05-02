package com.citi.cfg.service;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.citi.cfg.bean.Transaction;

public class ReadFileService 
{
	private String filename;
	
	public ReadFileService(String filename) 
	{
		this.filename=filename;
	}
	
	public void readFile() throws IOException
	{
		String filepath="D://CitiBridge//Project//files//"+filename;
		File file = new File(filepath);
		
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		ArrayList<Transaction> ar=new ArrayList<Transaction>();
		while((line=br.readLine()) != null)
		{
			Transaction t= new Transaction();
			String[] details=line.split("\\s+");
			
//			for(String s:details)
//			{	
//				System.out.println(s);
//			}
			
			t.setTransactionRef(details[0].substring(0, 12));
			t.setValueDate(details[0].substring(12,20));
			t.setPayerName(details[0].substring(20));
			
			t.setPayerAccount(details[1].substring(0,12));
			t.setPayeeName(details[1].substring(12));
			
			t.setPayeeeAccount(details[2].substring(0,12));
			
			t.setAmount(Float.parseFloat(details[3]));
			
			ar.add(t);
		}
		for(Transaction j:ar)
		{
			System.out.println(j);
		}
		br.close();
	}
	
}
