package com.te.essportal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee_Info {
	@Id
	private int Employee_Id;
	@Column(length = 50)
	private String name;
	private String type;
	@Column(length = 100)
	private String email;
	@Column(length = 50)
	private String pass;
}
