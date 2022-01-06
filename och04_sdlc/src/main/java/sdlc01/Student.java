package sdlc01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	private String name;
	private int age;	
	
	public void destroy() throws Exception {
		System.out.println("Students의 destroy() --> 소멸자가 소멸되기 전..");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Student afterPropertiesSet --> 생성자 생성 이후");
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	
}
