package com.ghanshyam.dto;

public class DTO {
	 private String user;
	    private String password;
	    private String fullname;
	    private String address;
	    private int salary;
	    
	    
		public DTO() {
			super();
			
		}


		public DTO(String user, String password, String fullname, String address, int salary) {
			super();
			this.user = user;
			this.password = password;
			this.fullname = fullname;
			this.address = address;
			this.salary = salary;
		}


		public String getUser() {
			return user;
		}


		public void setUser(String user) {
			this.user = user;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getFullname() {
			return fullname;
		}


		public void setFullname(String fullname) {
			this.fullname = fullname;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public int getSalary() {
			return salary;
		}


		public void setSalary(int salary) {
			this.salary = salary;
		}
	    
	    
	    
}
