package com.moraes.LinkVault.link;

import java.time.Instant;

import com.moraes.LinkVault.link.dto.LinkRequestDTO;
import com.moraes.LinkVault.link.dto.LinkResponseDTO;

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

	public LinkModel(){}
	
	
	public Integer getId() {
		return id;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getDescription() {
		return linkDescription;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}

	public void update(String link, String description) {
		this.link = link;
		linkDescription = description;
		updatedAt = Instant.now();
	}

	public static LinkModel of(LinkRequestDTO dto) {
		return new LinkModel(dto.link(), dto.description());
	}

	public static LinkModel of(LinkResponseDTO dto) {
		return new LinkModel(dto.link(), dto.description());
	}
	
	@Override
	public String toString() {
		return String.valueOf(link) + String.valueOf(linkDescription);
	}
}
