package com.oracle.oBootJpa01.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
//DTO 대신 Entity 라고 함_ Entity라고 써야 JPA매니저에서 관리함 
@Entity
public class Member {
	// PK를 말함. @Id. 
	@Id 
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
