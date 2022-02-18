package com.oracle.oBootJpa02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
//entity라고 안쓰면 entity manager에서 관리 안함
@Entity
@Getter //롬북 
@Setter
@SequenceGenerator(name = "member_seq_gen", //객체에서 사용할 이름
				   sequenceName = "member_seq_generator", //매핑할 DB 시퀀스 이름 / DB에서 사용할 시퀀스명
				   initialValue = 1,
				   allocationSize = 1		
				   )
@Table(name = "member1")
public class Member {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,
						generator = "member_seq_gen" //객체에서 사용할 이름과 같아야 
					   )
		
		@Column(name = "member_id", precision = 10)
		private Long id; //필드명. 
		@Column (name = "user_name", length = 50)
		private String name;
		
		//FK 지정하는 법 // foreign키가 있는 (많은)쪽에서 걸어줘라
		@ManyToOne
		@JoinColumn(name = "team_id") //멤버쪽에서 팀에 FK를 걸어준다 / foreign키 있는 쪽에서 걸어준다. 
		private Team		team;
		
		@Transient
		private Long teamid; //실제 컬럼은 아닌데 버퍼로는 가져갈 필요가 있을 때 
		@Transient
		private String teamname;

	
}
