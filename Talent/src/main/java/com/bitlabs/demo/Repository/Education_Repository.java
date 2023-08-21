package com.bitlabs.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitlabs.demo.Model.Education_Details;


public interface Education_Repository extends JpaRepository <Education_Details,Long>{

}
