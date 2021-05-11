package com.au.aums.model.dto;

public class ClientDTO {
	private String client;
    private Long total;
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public ClientDTO(String client, Long total) {
		super();
		this.client = client;
		this.total = total;
	}
	public ClientDTO() {
		
	}
    
}
