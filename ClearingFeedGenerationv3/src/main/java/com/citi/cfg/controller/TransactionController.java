package com.citi.cfg.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.citi.cfg.bean.Transaction;
import com.citi.cfg.service.ReadFileService;
import com.citi.cfg.service.TransactionService;
import com.citi.cfg.service.UploadService;

import lombok.extern.slf4j.Slf4j;

//Tomcat Jasper is responsible to convert jsp to servlet so add dependency from maven

//http://localhost:8090/swagger-ui.html

@Controller
@Slf4j
public class TransactionController {
	private String filename;
	
	ArrayList<Transaction> transactions;
	
	@Autowired
	private TransactionService transactionService;

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}

	@RequestMapping("/logout-success")
	public String logout() {
		return "logout.jsp";
	}

	@RequestMapping("/upload")
	public String upload() {
		return "upload.jsp";
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST) // //new annotation since 4.3
	public String singleFileUpload(@RequestBody MultipartFile file, RedirectAttributes redirectAttributes) {
		UploadService uploadServie = new UploadService();
		boolean flag = uploadServie.uploadFile(file);
		filename = file.getOriginalFilename();
		if (!flag) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		} else {
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
		}
		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus.jsp";
	}

	@RequestMapping("/validtran")
	public String getValidTransactions(Model model) throws IOException {
		ReadFileService readFileService = new ReadFileService(filename);
		transactions= readFileService.readFile();
		for(Transaction t: transactions) {
			log.info(t.toString());
			transactionService.addTransaction(t);
		}
		model.addAttribute("transactions", transactionService.getAllTransactions());

		return "validTransactions.jsp";
	}
	
	@RequestMapping("/failedtran")
	public String getFailedTransactions(Model model) throws IOException {
		ReadFileService readFileService = new ReadFileService(filename);
		transactions= readFileService.readFile();
		for(Transaction t: transactions) {
			log.info(t.toString());
			transactionService.addTransaction(t);
		}
		model.addAttribute("transactions", transactionService.getFailedTransactions());

		return "failedTransactions.jsp";
	}
}
