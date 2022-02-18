package com.oracle.oBootJpa02.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.domain.Team;
//DAO는 언제든지 부품처럼 교체할 수 있기 때문에 @가 없음
public class JpaMemberRepository implements MemberRepository {
	private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
    	this.em = em;
    }

	
	@Override
	public Member save(Member member) {
		//팀 저장
		Team team = new Team();
		team.setName(member.getTeamname());
		em.persist(team);
		//회원저장
		member.setTeam(team); // 단뱡향 연관관계 설정, 참조 지정
		em.persist(member); //없으면 insert 있으면 update
		return member;
	}

	
	@Override
	public List<Member> findAll() {
		List<Member> memberList = em.createQuery("select m from Member m", Member.class)
									 .getResultList(); //이 멤버는 멤버테이블이 아님. 객체를 가리킴.
		//domain의 Member를 가리키고 실제로는 member1로 들어감. @Table 로 지정 안하면 진짜 Member로 들어감. 
		return memberList;
	}

	@Override
	public Member findByMember(Long id) {
		//						Entity        pk
		Member member = em.find(Member.class, id);
		return member;
	}

	@Override
	public int updateByMember(Member member) {
		int result = 0;
		System.out.println("JpaMemberRepository updateByMember member.getId()->"+member.getId());
		Member member3 = em.find(Member.class, member.getId());
		if ( member3 != null) {
			//팀 저장
			System.out.println("JpaMemberRepository updateByMember member.getTeamid()->"+member.getTeamid());
			Team team = em.find(Team.class, member.getTeamid());
			if (team != null) {
				System.out.println("JpaMemberRepository updateByMember member.getTeamname()->"+member.getTeamname());
				team.setName(member.getTeamname());
				em.persist(team);
			}
			//회원 저장
			System.out.println("JpaMemberRepository updateByMember member.getName()->"+member.getName());
			member3.setTeam(team); //단방향 연관관계 설정, 참조 저장
			member3.setName(member.getName());
			em.persist(member3);
			System.out.println("JpaMemberRepository updateByMember member.getName()->"+member.getName());
			
			result = 1;
			
		} else {
			 result = 0;
			 System.out.println("JpaMemberRepository updateByMember No Exist.."); 
		}
		
		return result;
	}

}
