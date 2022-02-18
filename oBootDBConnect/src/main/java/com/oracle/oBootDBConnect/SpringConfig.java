package com.oracle.oBootDBConnect;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.oBootDBConnect.repository.MemberRepository;
import com.oracle.oBootDBConnect.repository.MemoryMemberRepository;
import com.oracle.oBootDBConnect.repository.jdbcMemberRepository;

@Configuration
public class SpringConfig {
	private final DataSource dataSource;
		public SpringConfig(DataSource dataSource) {
			this.dataSource = dataSource;
		}
	
		//Configuration에 Bean이 있으면 component와 같은 효과 
		@Bean
		public MemberRepository memberRepository() {
			return new MemoryMemberRepository();
			//return new jdbcMemberRepository(dataSource);
		}
		
		
		
}
