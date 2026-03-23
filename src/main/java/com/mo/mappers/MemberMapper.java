package com.mo.mappers;

import com.mo.entity.Member;
import com.mo.requestdto.MemberRequestDto;
import com.mo.responddto.MemberRespondDto;

public class MemberMapper {
	
	public static Member toEntity(MemberRequestDto dto) {
		
		Member member = new Member();
		
		member.setFirstName(dto.getFirstName());
		member.setLastName(dto.getLastName());
		member.setPhone(dto.getPhone());
		member.setNrc(dto.getNrc());
		member.setAddress(dto.getAddress());
		member.setStatus(dto.getStatus());
		
		return member;
		
	}
	
	public static MemberRespondDto toDTO(Member member) {

        MemberRespondDto dto = new MemberRespondDto();

        dto.setId(member.getId());
        dto.setFullName(member.getFirstName() + " " + member.getLastName());
        dto.setPhone(member.getPhone());
        dto.setNrc(member.getNrc());
        dto.setAddress(member.getAddress());
        dto.setJoinDate(member.getJoinDate());
        dto.setStatus(member.getStatus());

        return dto; 
		
	}

}
