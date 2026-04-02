package com.mo.service;

import org.springframework.data.domain.Page;

import com.mo.dto.request.MemberRequestDto;
import com.mo.dto.respond.MemberRespondDto;

public interface MemberService {

		MemberRespondDto findById(Long id);
		
		MemberRespondDto createMember(MemberRequestDto memberDto);
		
//		List<MemberRespondDto> findAll();
		
		MemberRespondDto updateMemberData(MemberRequestDto updateMember, Long id);
		
		void deleteMember(Long id);
		
		Page<MemberRespondDto> getAllMember(int page, int size);
}
