package com.citi.cfg.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.citi.cfg.config.Config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploadService {
	@Autowired
	Config config;

	private String UPLOADED_FOLDER;

	@PostConstruct
	void init() {
		UPLOADED_FOLDER = config.getUploadFolder();
	}

	public boolean uploadFile(MultipartFile file) {
		log.info(file.toString());
		log.info(file.getOriginalFilename());
		if (file.isEmpty()) {
			return false;
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
