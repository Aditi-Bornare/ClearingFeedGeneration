package com.citi.cfg.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Tomcat Jasper is responsible to convert jsp to servlet so add dependency from maven

@Controller
public class TransactionController {

	@RequestMapping("/")
	public String index() 
	{
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String login() 
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logout() 
	{
		return "logout.jsp";
	}
	
	@RequestMapping("/upload")
	public String upload()
	{
		return "upload.jsp";
	}

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://CitiBridge//Project//files//";
    
    @RequestMapping(value="/uploadfile", method= RequestMethod.POST) // //new annotation since 4.3
    public String singleFileUpload(@RequestBody MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
    	System.out.println(file);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus.jsp";
    }
}
