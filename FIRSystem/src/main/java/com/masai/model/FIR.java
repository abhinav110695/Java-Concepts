package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class FIR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer firId;
	private String crimeDetail;
	private LocalDateTime timeStamp;  
	private String policeStation;
	
	@ManyToOne
	private User users;
	
}
