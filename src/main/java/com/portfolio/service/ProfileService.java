package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.entity.Profile;
import com.portfolio.repository.ProfileRepository;


@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	public List<Profile> getProfileList(){
		return profileRepository.findAll();
	}

	public Profile getProfile(Long profileId) {
		return profileRepository.findById(profileId).orElse(null);
	}
	
	public Profile saveProfile(Profile profile) {
		profileRepository.save(profile);
		return profile;
	}
	
	public Profile updateProfile(Long CourseId, Profile profile) {
		Profile exitProfile = profileRepository.findById(CourseId).orElse(null);
		if(exitProfile != null) {
			profileRepository.save(profile);
		}
		return profile;
	}
	
	public Profile getFamilyTree(Long grandFatherId) {
		Profile grandParent = profileRepository.findById(grandFatherId).orElse(null);
		return grandParent;
	}
}
