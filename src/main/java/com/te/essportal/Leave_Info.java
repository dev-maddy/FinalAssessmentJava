package com.te.essportal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Leave_Info {
	@Id
	private int Employee1_Id;
	@Column(length = 50)
	private String Leave_Date;
	@Column(length = 50)
	private String Leave_Status;

}
