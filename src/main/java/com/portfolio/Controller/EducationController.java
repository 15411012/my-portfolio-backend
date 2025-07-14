package com.portfolio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.Education;
import com.portfolio.service.EducationService;


@RequestMapping("/education")
@RestController
public class EducationController {

	@Autowired
	EducationService educationService;
	
	@GetMapping("")
	public ResponseEntity<?> getEducations(){
		return ResponseEntity.status(HttpStatus.OK).body(educationService.getEducationList());
	}
	
    @GetMapping("/{educationId}")
	public ResponseEntity<?> getEducation(@PathVariable int educationId) {
		return ResponseEntity.status(HttpStatus.OK).body(educationService.getEducation(educationId));
	 }
	 
	@PostMapping("")
	public ResponseEntity<?> saveEducations(@RequestBody Education education){
		return ResponseEntity.status(HttpStatus.OK).body(educationService.saveEducation(education));
	}
	
	@PutMapping("/{educationId}")
	public ResponseEntity<?> updateEducations(@PathVariable int educationId, @RequestBody Education education){
		return ResponseEntity.status(HttpStatus.OK).body(educationService.updateEducation(educationId, education));
	}
}
