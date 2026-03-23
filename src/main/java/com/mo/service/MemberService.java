package com.mo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.dto.MemberRequestDto;
import com.mo.dto.MemberRespondDto;
import com.mo.entity.Member;
import com.mo.mappers.MemberMapper;
import com.mo.repository.MemberRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepo memberRepo;

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

//	private void validateUniquenes(MemberRequestDto newMember, MemberRespondDto existingMember) {
//
//		if (existingMember == null || !existingMember.getPhone().equals(newMember.getPhone())) {
//			if (memberRepo.existsByPhone(newMember.getPhone())) {
//				throw new IllegalArgumentException("Phone already exists" + newMember.getPhone());
//
//			}
//		}
//
//		if (existingMember == null || !existingMember.getNrc().equals(newMember.getNrc())) {
//			if (memberRepo.existsByNrc(newMember.getNrc())) {
//				throw new IllegalArgumentException("NRC already exists: " + newMember.getNrc());
//			}
//		}
//
//	}
}
