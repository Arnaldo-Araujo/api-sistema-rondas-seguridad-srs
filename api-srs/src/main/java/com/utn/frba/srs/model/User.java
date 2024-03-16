package com.utn.frba.srs.model;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn
	private SecurityCompany securityCompany;
	private String name;
	@NotBlank
	private String password;
	private String lastname;
	private String documentType;
	private String documentValue;
	private String mail;
	private String role;
	private Boolean active;


}
