/*package com.bitlabs.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ResumeParserService {

    public List<String> identifySections(String resumeText) {
        List<String> sections = new ArrayList<>();

        // Define the patterns for different sections
    //    Pattern contactPattern = Pattern.compile("Contact\\s*Information", Pattern.CASE_INSENSITIVE);
        Pattern educationPattern = Pattern.compile("Education", Pattern.CASE_INSENSITIVE);
        Pattern experiencePattern = Pattern.compile("Work\\s*Experience|Experience", Pattern.CASE_INSENSITIVE);

        // Match patterns against the resume text
    //    Matcher contactMatcher = contactPattern.matcher(resumeText);
        Matcher educationMatcher = educationPattern.matcher(resumeText);
        Matcher experienceMatcher = experiencePattern.matcher(resumeText);

        // Find matching sections and add them to the list
//        if (contactMatcher.find()) {
//            sections.add("Contact Information");
//        }
        if (educationMatcher.find()) {
            sections.add("Education");
        }
        if (experienceMatcher.find()) {
            sections.add("Work Experience");
        }

        return sections;
    }
}*/