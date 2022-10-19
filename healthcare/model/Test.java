package com.springboot.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="health")
public class Test {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long testId;
	
	@Column(name="test_Name")
	private String testName;
    
	//Default constructor
	public Test() {
		super();
	}

	public Test(long testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
    
	
}