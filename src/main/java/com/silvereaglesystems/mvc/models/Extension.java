package com.silvereaglesystems.mvc.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data public class Extension {
	
	private Description description;
	
	private String key;
	
	private String company;
	
	private String version;
	
	private Client client;

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
