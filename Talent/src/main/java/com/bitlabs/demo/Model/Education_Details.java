package com.bitlabs.demo.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Education_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer education_id;
    private String ssc_school_name;
	private Integer ssc_percentage;
	private Integer ssc_year_of_passing;
	private String inter_college_name ;
	private Integer inter_percentage ;
	private Integer inter_year_of_passing;
	private String inter_branch;
	private String graduation;
	private String graduation_branch;
	private String graduation_college_name ;
	private Integer graduation_percentage;
	private Integer graduation_year_of_passing;
	private String post_graduation;
	private String post_graduation_branch;
	private String post_graduation_college_name ;
	private Integer post_graduation_percentage;
	private Integer post_graduation_year_of_passing;
	
	
}
