package com.au.aums.model.dto;

public class SkillDTO {
	private String skill;
    private Long total;
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public SkillDTO(String skill, Long total) {
		super();
		this.skill = skill;
		this.total = total;
	}
	

	public SkillDTO() {
		
	}
    

}