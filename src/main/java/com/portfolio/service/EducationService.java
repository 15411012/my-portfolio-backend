package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.entity.Education;
import com.portfolio.repository.EducationRepository;

@Service
public class EducationService {
	
	@Autowired
	EducationRepository educationRepository;
	
	public List<Education> getEducationList(){
		return educationRepository.findAll();
	}

	public Education getEducation(int educationId) {
		return educationRepository.findById(educationId).orElse(null);
	}
	
	public Education saveEducation(Education education) {
		educationRepository.save(education);
		return education;
	}
	
	public Education updateEducation(int educationId, Education education) {
		Education exitEducation = educationRepository.findById(educationId).orElse(null);
		if(exitEducation != null) {
			educationRepository.save(education);
		}
		return education;
	}
}
