package com.oracle.oBootAPI01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.oBootAPI01.domain.Member;
import com.oracle.oBootAPI01.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
	private final MemberRepository memberRepository;
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	//회원가입
	public Long join(Member member) {
		System.out.println("MemberService join member.getName()->"+member.getName());
		Long id = memberRepository.save(member);
		return id;
	}
	
	//전체회원 조회
	public List<Member> getListAllMember() {
		List<Member> listMember = memberRepository.findAll();
		System.out.println("MemberServide getListAllMember listMember.size()->"+listMember.size());
		
		return listMember;
	}
	
	
}
