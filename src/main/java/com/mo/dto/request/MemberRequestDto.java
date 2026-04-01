package com.mo.dto.request;

import com.mo.validation.ValidateMember;

import lombok.Data;

@Data
@ValidateMember
public class MemberRequestDto {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String nrc;
	private String address;
	private Boolean status;
}
