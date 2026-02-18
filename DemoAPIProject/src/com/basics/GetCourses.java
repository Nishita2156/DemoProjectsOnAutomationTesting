package com.basics;

public class GetCourses {
	//creating POJO class for complex json 
	
	private String url;
	private String services;
	private String expertise;
	private Courses courses;
	private String instructor;
	//from source-->generate getters and setters method OR alt+shift+s
	//for the courses we have to create another sub class so that we can handle the nested json
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	private String linkedIn;
	 
	

}
