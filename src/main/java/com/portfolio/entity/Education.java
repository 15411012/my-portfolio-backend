package com.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Education {

	@Id
	private int educationId;
	private String intituteName;
	private String instituteLink;
	private String courseName;
	private String subjectName;
	private String cityName;
	private String startDate;
	private String endDate;
}
