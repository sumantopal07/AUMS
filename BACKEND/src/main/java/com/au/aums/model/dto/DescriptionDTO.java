package com.au.aums.model.dto;

public class DescriptionDTO {
	private String description;
    private Long total;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public DescriptionDTO(String description, Long total) {
		super();
		this.description = description;
		this.total = total;
	}
public DescriptionDTO() {
		
	}
}
