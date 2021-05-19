package com.ayan.model;

public class College {
	
	private String college_name;
	private String bio;
	private String contact_email;
	private String address;
	private String fac_to_stu_ratio;
	private int placement_percent;
	private int min_percent;
	private String best_branch;
	
	public College()
	{
		super();
	}
	public College( String college_name,String bio,String contact_email,String address,String fac_to_stu_ratio,int placement_percent,int min_percent,String best_branch ) {
		super();
		this.college_name = college_name;
		this.bio = bio;
		this.contact_email = contact_email;
		this.address = address;
		this.fac_to_stu_ratio = fac_to_stu_ratio;
		this.placement_percent = placement_percent;
		this.min_percent = min_percent;
		this.best_branch = best_branch;
		
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getFac_to_stu_ratio() {
		return fac_to_stu_ratio;
	}

	public void setFac_to_stu_ratio(String fac_to_stu_ratio) {
		this.fac_to_stu_ratio = fac_to_stu_ratio;
	}

	public int getPlacement_percent() {
		return placement_percent;
	}

	public void setPlacement_percent(int placement_percent) {
		this.placement_percent = placement_percent;
	}
	public int getMin_percent() {
		return min_percent;
	}
	public void setMin_percent(int min_percent) {
		this.min_percent = min_percent;
	}
	public String getBest_branch() {
		return best_branch;
	}
	public void setBest_branch(String best_branch) {
		this.best_branch = best_branch;
	}

}
