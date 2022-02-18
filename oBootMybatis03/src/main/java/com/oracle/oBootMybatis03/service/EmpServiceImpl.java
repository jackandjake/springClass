package com.oracle.oBootMybatis03.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootMybatis03.dao.DeptDao;
import com.oracle.oBootMybatis03.dao.EmpDao;
import com.oracle.oBootMybatis03.dao.Member1Dao;
import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.DeptVO;
import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.EmpDept;
import com.oracle.oBootMybatis03.model.Member3;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
	@Autowired
	private	DeptDao	dd;
	@Autowired
	private Member1Dao md;
	
	@Override
	public int total() {
		System.out.println("EmpServiceImpl Start total..." );
		int totCnt = ed.total();
		System.out.println("EmpServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listEmp Start..." );
		empList = ed.listEmp(emp);
		System.out.println("EmpServiceImpl listEmp empList.size()->" +empList.size());
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpServiceImpl detail ...");
		Emp emp = null;
		emp = ed.detail(empno);
		return emp;
		
	}

	@Override 
	public int update(Emp emp) {
		System.out.println("EmpServiceImple update ...");
		int kkk = 0;
		kkk = ed.update(emp);
		return kkk;

	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listManager Start...");
		empList = ed.listManager();
		System.out.println("EmpServiceImpl listEmp empList.size()->" +empList.size());
		return empList;
		
		// empList = ed.listManager();  --> 과제!!!!!
		// Dao --> empList = session.selectList("tkSelectManager"); 
		// 관리자만 Get List<Emp> 방식으로
		// model. manager에 있는 사람들만 골라서 
	}

	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("EmpServiceImple deptSelect Start..");
		deptList = dd.deptSelect();
		System.out.println("EmpServiceImple deptSelect deptList.size()->" + deptList.size());
		return deptList;
	}

	@Override
	public int insert(Emp emp) {
		int result = 0;
		System.out.println("EmpServiceImple insert Start...");
		result = ed.insert(emp);
		return result;
	}

	@Override
	public int delete(int empno) {
		int result = 0;
		System.out.println("EmpServiceImple delete Start...");
		result = ed.delete(empno);
		return result;
	}

	@Override
	public List<EmpDept> listEmpDept() {  // 1
		List<EmpDept> empDeptList = null;
		System.out.println("EmpServiceImple listEmpDept Start..");
		empDeptList = ed.listEmpDept();
		System.out.println("EmpServiceImple listEmpDept empDeptListl.size()->"+empDeptList.size());
		return empDeptList;
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		System.out.println("EmpServiceImpl inserDept Start...");
		dd.insertDept(deptVO);
	}

	@Override
	public void selListDept(HashMap<String, Object> map) {
		System.out.println("EmpServiceImpl selListDept Start...");
		dd.selListDept(map);
		
	}

	@Override
	public int memCount(String id) {
		System.out.println("EmpServiceImpl memCount id ->"+id);
		return md.memCount(id);
	}

	@Override
	public List<Member3> listMem(Member3 member3) {
		System.out.println("EmpServiceImpl listMem Start...");
		return md.listMem(member3);
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		System.out.println("EmpServiceImpl listEmp Start...");
		return ed.listEmp(empDept);
	}

	@Override
	public String deptName(int deptno) {
		System.out.println("EmpServiceImple deptName Start..");
		return ed.deptName(deptno);
	}

	
}
