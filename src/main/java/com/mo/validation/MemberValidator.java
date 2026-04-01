package com.mo.validation;

import java.util.regex.Pattern;

import com.mo.dto.request.MemberRequestDto;
import com.mo.exception.CustomValidationException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MemberValidator implements ConstraintValidator<ValidateMember, MemberRequestDto> {

	private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{11}$");
	private static final Pattern NRC_PATTERN = Pattern.compile("^[0-9]{1,2}/[A-Za-z]+\\([A-Za-z]+\\)[0-9]{6}$");

	@Override
	public boolean isValid(MemberRequestDto dto, ConstraintValidatorContext context) {

		if (dto == null) {
			throw new CustomValidationException("Member", "MISSING_OBJECT", "Member Request is empty!");
		}

		if (dto.getFirstName() == null) {

			throw new CustomValidationException("First Name", "MISSING_FIELD", "Member first name is empty!");

		}

		if (dto.getLastName() == null) {

			throw new CustomValidationException("Last Name", "MISSING_FIELD", "Member last name is empty!");

		}

		if (dto.getPhone() == null || !PHONE_PATTERN.matcher(dto.getPhone()).matches()) {
			throw new CustomValidationException("Phone Number", "INVALID_FORMAT", "Invalid Phone number format");
		}
		
		String nrc = dto.getNrc(); 
        if (nrc == null || nrc.isEmpty()) {
            throw new CustomValidationException("NRC", "MISSING_FIELD", "NRC is required!");
        }

        if (!NRC_PATTERN.matcher(nrc).matches()) {
            throw new CustomValidationException("NRC", "INVALID_FORMAT", "Invalid NRC format");
        }

        String address = dto.getAddress(); 
        if (address == null || address.isEmpty()) {
            throw new CustomValidationException("Address", "MISSING_FIELD", "Address is required!");
        }
		return true;
	}

}
