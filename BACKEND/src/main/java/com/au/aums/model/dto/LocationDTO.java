package com.au.aums.model.dto;

public class LocationDTO {
	private String location;
    public LocationDTO(String location, Long total) {
		super();
		this.location = location;
		this.total = total;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	private Long total;
	public LocationDTO() {
		
	}
}
