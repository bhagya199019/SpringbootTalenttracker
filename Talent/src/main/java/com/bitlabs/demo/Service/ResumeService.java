package com.bitlabs.demo.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitlabs.demo.Model.Skill;
import com.bitlabs.demo.Repository.SkillRepository;

@Service
public class ResumeService {
    @Autowired
    private SkillRepository skillRepository;

    public void extractSkillsAndStore(MultipartFile file) {
        // Extract text from the PDF using PDFBox or iText
        String resumeText = extractTextFromPDF(file);
        System.out.println("resume text is"+resumeText);

        // Perform skill extraction using keyword matching or NLP techniques
        List<String> extractedSkills = extractSkillsFromText(resumeText);

        // Store the extracted skills in the database
        storeSkillsInDatabase(extractedSkills);
    }

    private String extractTextFromPDF(MultipartFile file) {
        try {
            PDDocument document = PDDocument.load(file.getInputStream());

            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(document);

            document.close();
            return text;
        } catch (IOException e) {
            throw new RuntimeException("Error extracting text from PDF: " + e.getMessage());
        }
    }

    private List<String> extractSkillsFromText(String resumeText) {
        List<String> predefinedSkills = Arrays.asList("Java", "Python", "SQL", "JavaScript", "React", "Spring", "Machine Learning");
        List<String> extractedSkills = new ArrayList<>();

        for (String skill : predefinedSkills) {
            if (resumeText.toLowerCase().contains(skill.toLowerCase())) {
                extractedSkills.add(skill);
            }
        }

        return extractedSkills;
    }


    private void storeSkillsInDatabase(List<String> skills) {
        for (String skill : skills) {
            skillRepository.save(new Skill(skill));
        }
    }
}