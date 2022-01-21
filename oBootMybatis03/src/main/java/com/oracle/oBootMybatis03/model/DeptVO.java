package com.oracle.oBootMybatis03.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptVO {

	private int 		deptno;
	private String		dname;
	private String		loc;
	private int			odeptno;
	private String		odname;
	private String		oloc;
}


//VO는 Virtual Object_Read Only 개념으로 쓰이면. DTO는 저장하고 그럴때 동시에 쓰여지고