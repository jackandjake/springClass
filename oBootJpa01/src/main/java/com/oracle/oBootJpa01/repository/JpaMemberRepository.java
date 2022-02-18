package com.oracle.oBootJpa01.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.oracle.oBootJpa01.domain.Member;

public class JpaMemberRepository implements MemberRepository {
	private final EntityManager em;
	public JpaMemberRepository(EntityManager em) {
		this.em= em;
	}
	
	@Override
	public Member save(Member member) {
		//JPA에서의 저장
		em.persist(member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		List<Member> memberList = em.createQuery("select a from Member a", Member.class)
					              .getResultList();
		
		return memberList;
	}

	@Override
	public List<Member> findByNames(String name) {
		String pname = name + '%';
		System.out.println("JpaMemberRepository findByNames name->"+name);
		
		List<Member> memberList = em.createQuery("select m from Member m where name Like :name ", Member.class)
				                    .setParameter("name", pname)
				                    .getResultList();
		System.out.println("JpaMemberRepository memberList.size()->"+memberList.size());
		return memberList;
	}
	
}
