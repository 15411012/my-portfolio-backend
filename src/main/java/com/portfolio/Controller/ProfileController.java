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

import com.portfolio.entity.Profile;
import com.portfolio.service.ProfileService;


@RequestMapping("/profile")
@RestController
public class ProfileController {
	
	@Autowired
	ProfileService profileService;

	
	@GetMapping("")
	public ResponseEntity<?> getProfiles(){
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfileList());
	}
	
    @GetMapping("/{profileId}")
	public ResponseEntity<?> getProfile(@PathVariable Long profileId) {
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfile(profileId));
	 }
	 
	@PostMapping("")
	public ResponseEntity<?> saveProfile(@RequestBody Profile profile){
		return ResponseEntity.status(HttpStatus.OK).body(profileService.saveProfile(profile));
	}
	
	@PutMapping("/{profileId}")
	public ResponseEntity<?> updateProfile(@PathVariable Long profileId, @RequestBody Profile profile){
		return ResponseEntity.status(HttpStatus.OK).body(profileService.updateProfile(profileId, profile));
	}
	
	
	@GetMapping("/family-tree/{grandFatherId}")
	public ResponseEntity<?> getFamilyTree(@PathVariable Long grandFatherId) {
	    return ResponseEntity.status(HttpStatus.OK).body(profileService.getFamilyTree(grandFatherId));
	}

 
 
}
