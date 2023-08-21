package com.bitlabs.demo.Service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlabs.demo.Model.Education_Details;
import com.bitlabs.demo.Repository.Education_Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EducationService {

    @Autowired
    private Education_Repository educationRepository;

    public void extractAndStoreEducationDetails(InputStream pdfInputStream) {
        try {
            PDDocument document = PDDocument.load(pdfInputStream);
            PDFTextStripper textStripper = new PDFTextStripper();
            String pdfText = textStripper.getText(document);
            document.close();

            // Regular expression pattern to match education details
         
            
            String pattern1 = "(M\\. Tech|B\\. Tech):\\s*(.+?) with ([0-9.]+) CGPA-(\\d{4})\\s*(.+),\\s*(.+)";
            System.out.println(pattern1);
            Pattern regex1 = Pattern.compile(pattern1, Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = regex1.matcher(pdfText);
            String pattern2 = "Intermediate ([\\w\\s]+) with ([0-9.]+) (?:CGPA|%) - (\\d{4})\\s*(.+?),\\s*(.+?)\\.";
         

            Pattern regex2 = Pattern.compile(pattern2, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = regex2.matcher(pdfText);
            Education_Details education = new Education_Details();
         // Inside the while loop of extractAndStoreEducationDetails method
            String pattern3 = "(Secondary School Certificate) with\\s+([0-9.]+) (?:CGPA|%)\\s*-\\s*(\\d{4})\\s*(.+?),\\s*(.+?)\\.";
         

            Pattern regex3 = Pattern.compile(pattern3, Pattern.CASE_INSENSITIVE);
            Matcher matcher3 = regex3.matcher(pdfText);

            while (matcher1.find()) {
               
                String educationLevel1 = matcher1.group(1);
                System.out.println(educationLevel1);

                switch (educationLevel1) {
                    case "B. Tech":
                        education.setGraduation("B. Tech");
                        education.setGraduation_branch(matcher1.group(2));
                        education.setGraduation_percentage((int) Double.parseDouble(matcher1.group(3)));
                        education.setGraduation_year_of_passing(Integer.parseInt(matcher1.group(4)));
                        education.setGraduation_college_name(matcher1.group(5));
                        break;
                   
                    case "M. Tech":
                        education.setPost_graduation("M. Tech");
                        education.setPost_graduation_branch(matcher1.group(2));
                        education.setPost_graduation_percentage((int) Double.parseDouble(matcher1.group(3)));
                        education.setPost_graduation_year_of_passing(Integer.parseInt(matcher1.group(4)));
                        education.setPost_graduation_college_name(matcher1.group(5));
                        break;
                   
                   
                }

          
            
            }
            while (matcher2.find()) {
            	
             String educationLevel2 = matcher2.group(1);
             System.out.println(educationLevel2);
              education.setInter_branch(matcher2.group(1));
         
              education.setInter_percentage((int)Double.parseDouble(matcher2.group(2)));
              education.setInter_year_of_passing(Integer.parseInt(matcher2.group(3)));
              education.setInter_college_name(matcher2.group(4));
       
        
            }
                
                
            

            while (matcher3.find()) {
               
            	String educationLevel3 = matcher3.group(1);
            	  System.out.println(educationLevel3);
            	 education.setSsc_percentage((int) Double.parseDouble(matcher3.group(2)));
                 education.setSsc_year_of_passing(Integer.parseInt(matcher3.group(3)));
                 education.setSsc_school_name(matcher3.group(4));
       
                
            	
         
            }
            
              educationRepository.save(education);
            
            
            
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

           
    

