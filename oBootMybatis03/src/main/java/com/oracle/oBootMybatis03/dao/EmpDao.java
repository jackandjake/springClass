package com.oracle.oBootMybatis03.dao;

import java.util.List;

import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.EmpDept;

public interface EmpDao {
	int				total();
	List<Emp>		listEmp(Emp emp);
	Emp        	 	detail(int empno);
	int				update(Emp emp);
	List<Emp>   	listManager();
	int         	insert(Emp emp);
	int 			delete(int empno);
	List<EmpDept>	listEmpDept();
	List<EmpDept>   listEmp(EmpDept empDept);
	String          deptName(int deptno);
}

//이런게 오버로딩이다. 같이 떠있다. 같은 인터페이스에. 10, 17줄. 