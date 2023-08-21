package com.bitlabs.demo.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitlabs.demo.Service.EducationService;

@RestController
public class EducationController {

    @Autowired
    private EducationService educationExtractionService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "File is empty.";
        }

        educationExtractionService.extractAndStoreEducationDetails(file.getInputStream());
        return "File uploaded successfully.";
    }
}