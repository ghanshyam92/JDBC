package com.oritso.dto;

public class DtoEx {
	public String department;
	public String name;
	public int rollno;
	public String section;
	
	public DtoEx() {
		super();
		
	}

	public DtoEx(String department, String name, int rollno, String section) {
		super();
		this.department = department;
		this.name = name;
		this.rollno = rollno;
		this.section = section;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	

}
