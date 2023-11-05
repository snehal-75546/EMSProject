package com.app.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department extends BaseEntity {
	
	@Column
	private String departmentName;

}
