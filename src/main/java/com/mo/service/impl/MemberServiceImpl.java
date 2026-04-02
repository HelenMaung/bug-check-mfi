package com.mo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mo.dto.request.MemberRequestDto;
import com.mo.dto.respond.MemberRespondDto;
import com.mo.entity.Member;
import com.mo.mappers.MemberMapper;
import com.mo.repository.MemberRepo;
import com.mo.service.MemberService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepo memberRepo;
	
	@Override
	public MemberRespondDto findById(Long id) {

		Member member = memberRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		return MemberMapper.toDTO(member);
	}

	public MemberRespondDto createMember(MemberRequestDto memberDto) {
		Member member = MemberMapper.toEntity(memberDto);
//		validateUniqueness(memberDto, null);

		member.setJoinDate(LocalDateTime.now());

		Member saved = memberRepo.save(member);

		return MemberMapper.toDTO(saved);

	}

	public List<MemberRespondDto> findAll() {

		return memberRepo.findAll().stream().map(MemberMapper::toDTO).toList();
	}

	public MemberRespondDto updateMemberData(MemberRequestDto updateMember, Long id) {

		Member existingMember = memberRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		
		Member updateData = MemberMapper.toEntity(updateMember);
//		validateUniqueness(updateMember, existingMember);
		existingMember.setFirstName(updateData.getFirstName());
		existingMember.setLastName(updateData.getLastName());
		existingMember.setPhone(updateData.getPhone());
		existingMember.setNrc(updateData.getNrc());
		existingMember.setAddress(updateData.getAddress());
		existingMember.setStatus(updateData.getStatus());
		
	    Member saved = memberRepo.save(existingMember);
		
		return MemberMapper.toDTO(saved);
	}

	public void deleteMember(Long id) {

		if (!memberRepo.existsById(id)) {
			throw new EntityNotFoundException("Member not found");
		}

		memberRepo.deleteById(id);
	}

	@Override
	public Page<MemberRespondDto> getAllMember(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Member> entityPages = memberRepo.findAll(pageable);
		Page<MemberRespondDto> dtoPages = entityPages.map(entity -> MemberMapper.toDTO(entity));
		return dtoPages;
	}


}
