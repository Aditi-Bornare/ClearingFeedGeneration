package com.citi.cfg.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.cfg.bean.Transaction;
import com.citi.cfg.config.Config;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ReadFileService {
	private String filename;

	@Autowired
	Config config;

	private String filepath;

	@PostConstruct
	void init() {
		filepath = config.getUploadFolder();
	}

	public ReadFileService(String filename) {
		this.filename = filename;
	}
	
	public ArrayList<Transaction> readFile() throws IOException {
		filepath = filepath + filename;
		File file = new File(filepath);

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		ArrayList<Transaction> ar = new ArrayList<Transaction>();
		while ((line = br.readLine()) != null) {
			Transaction t = new Transaction();
			String[] details = line.split("\\s+");

			t.setTransactionRef(details[0].substring(0, 12));
			t.setValueDate(details[0].substring(12, 20));
			t.setPayerName(details[0].substring(20));

			t.setPayerAccount(details[1].substring(0, 12));
			t.setPayeeName(details[1].substring(12));

			t.setPayeeAccount(details[2].substring(0, 12));

			t.setAmount(Float.parseFloat(details[3]));
			
			if(t.status_of_transaction()) {
				t.setStatus("Successful");
			}
			else {
				t.setStatus("Failed");
			}

			ar.add(t);
		}
		br.close();
		return ar;
	}

}
