package com.moraes.LinkVault.link;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="link")
public class LinkModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="link")
	private String link;
	@Column(name="link_description")
	private String linkDescription;
	@Column(name="created_at")
	private Instant createdAt;
	@Column(name="updated_at")
	private Instant updatedAt;
	
	public LinkModel(String link, String linkDescription) {
		this.link = link;
		this.linkDescription = linkDescription;
		createdAt = Instant.now();
		updatedAt = Instant.now();
	}
	
	
	public Integer getid() {
		return id;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getDescription() {
		return linkDescription;
	}
	
	public Instant updated() {
		return updatedAt;
	}
	
	public Instant created() {
		return createdAt;
	}
	
	@Override
	public String toString() {
		return String.valueOf(link) + String.valueOf(linkDescription);
				
				
	}
}
