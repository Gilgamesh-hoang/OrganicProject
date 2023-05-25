package com.laptrinhweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact")
@EntityListeners(AuditingEntityListener.class) // de su dung createdBy..., duoc cau hinh trong jpaAuditingConfig
@Getter
@Setter
@NoArgsConstructor
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "message", columnDefinition = "TEXT")
	private String message;

	@Column(name = "full_name")
	private String name;

	@Column(name = "send_date")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date sendDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public ContactEntity(String email, String message, String name) {
		super();
		this.email = email;
		this.message = message;
		this.name = name;
	}

}
