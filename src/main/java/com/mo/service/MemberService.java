package com.mo.service;

import java.util.List;

import com.mo.dto.request.MemberRequestDto;
import com.mo.dto.respond.MemberRespondDto;

public interface MemberService {

		MemberRespondDto findById(Long id);
		
		MemberRespondDto createMember(MemberRequestDto memberDto);
		
		List<MemberRespondDto> findAll();
		
		MemberRespondDto updateMemberData(MemberRequestDto updateMember, Long id);
		
		void deleteMember(Long id);
}
