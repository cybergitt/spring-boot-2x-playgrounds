package com.coffeegit.springboot.jpamysql.model.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.coffeegit.springboot.jpamysql.model.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
	ignoreUnknown = true
)
public class RoleDto {

	@Enumerated(EnumType.STRING)
	private RoleEnum role;
}
