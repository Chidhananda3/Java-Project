package com.tap.modules;


	import java.sql.Date;

	public class user {

	    private int userId;
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private Date dob;

	    public user(String name, String email, String phoneNumber, Date dob) {
	        this.name = name;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.dob = dob;
	    }
	    public user(int userId, String name, String email, String phoneNumber, java.util.Date dob) {
	        this.userId = userId;
	        this.name = name;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.dob = new Date(dob.getTime()); // Convert java.util.Date to java.sql.Date
	    }

	    // Include getters and setters

	    public user(int userid2, String name2, String email2, String phonenumber2, java.util.Date dob2) {
			// TODO Auto-generated constructor stub
		}

		public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public Date getDob() {
	        return dob;
	    }

	    public void setDob(Date dob) {
	        this.dob = dob;
	    }
	    public String toString() {
	        return "user{" +
	                "userId=" + userId +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                ", phoneNumber='" + phoneNumber + '\'' +
	                ", dob=" + dob +
	                '}';
	    }
	}



