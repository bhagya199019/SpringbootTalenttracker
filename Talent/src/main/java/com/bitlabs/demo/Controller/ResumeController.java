package com.bitlabs.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitlabs.demo.Service.ResumeService;

@RestController
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/uploadResume")
    public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) {
        // Call the service to process the uploaded file
        resumeService.extractSkillsAndStore(file);
        return ResponseEntity.ok("Resume uploaded and skills extracted.");
    }
    
   
 

}