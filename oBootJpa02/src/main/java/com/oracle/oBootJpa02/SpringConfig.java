package com.oracle.oBootJpa02;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.oBootJpa02.repository.JpaMemberRepository;
import com.oracle.oBootJpa02.repository.MemberRepository;


@Configuration
public class SpringConfig {
	private final DataSource 	 dataSource;
	private final EntityManager  em;
	
		public SpringConfig(
					DataSource		dataSource,
					EntityManager   em) {
			this.dataSource = dataSource;
			this.em = em;
		}
		
		@Bean
		public MemberRepository memberRepository() {
			return new JpaMemberRepository(em);  //나중에 DB를 바꾸면 이부분을 바꿔주면 됨. 
		}
}
