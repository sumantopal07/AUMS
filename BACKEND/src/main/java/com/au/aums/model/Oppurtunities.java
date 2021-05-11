package com.au.aums.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Oppurtunities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oppId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	
	private String location;
	private String skill;
	private String client;
	private String description;
	private String date;
	
	
	private int minExp;
	private int demand;




	


	

	public Oppurtunities() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the oppId
	 */
	public int getOppId() {
		return oppId;
	}


	/**
	 * @param oppId the oppId to set
	 */
	public void setOppId(int oppId) {
		this.oppId = oppId;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the minExp
	 */
	public int getMinExp() {
		return minExp;
	}


	/**
	 * @param minExp the minExp to set
	 */
	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}


	/**
	 * @return the demand
	 */
	public int getDemand() {
		return demand;
	}


	/**
	 * @param demand the demand to set
	 */
	public void setDemand(int demand) {
		this.demand = demand;
	}


	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}


	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}



	@Override
	public String toString() {
		return "Oppurtunities [oppId=" + oppId + ", user=" + user + ", location=" + location + ", skill=" + skill
				+ ", client=" + client + ", description=" + description + ", date=" + date + ", minExp=" + minExp
				+ ", demand=" + demand + "]";
	}


	
	
	
	
	
}