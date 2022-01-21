package com.oracle.oBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.EmpDept;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession	session;
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("EmpDaoImpl Start total..." );
		
		// Result = > 14
		try {
			tot = session.selectOne("tkEmpTotal");
			System.out.println("EmpDaoImpl total tot->"+tot );
		} catch (Exception e) {
			System.out.println("EmpDaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}
	//Dao는 반드시 try catch 걸어줄것
	@Override     
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listEmp Start...");
		try {
			// Naming Rule			          Map Id	 parameter
			//empList = session.selectList("tkEmpListAll3", emp);
			empList = session.selectList("tkEmpListAll", emp);
		} catch(Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception ->" +e.getMessage());
		}
		return empList;
	}
	
	@Override
	public Emp detail(int empno) {
		System.out.println("EmpDaoImple detail start..");
		Emp emp = new Emp();
		try {
			//						 mapper Id, 		Parameter
			emp = session.selectOne("tkEmpSelOne",		empno);
			System.out.println("EmpDaoImpl detail getEname->" + emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception->" + e.getMessage());
		}
		return emp;
	}
	
	@Override
	public int update(Emp emp) {
		System.out.println("EmpDaoImpl update start..");
		int kkk=0;
		try {
			kkk = session.update("TKempUpdate", emp);  // 여러개의 파라미터를 넘길거라서 emp (DTO) 를 통째로 보내는 것
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception->"+e.getMessage());
		}
		return kkk;
	}
	
	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listManager Start...");
		try {
			//emp 관리자만 Select 				Naming Rule
			empList = session.selectList("tkSelectManager");
		} catch (Exception e) {
			System.out.println("EmpDatoImpl listManager Exceptio->"+e.getMessage());
		}
		return empList;
	}
	
	@Override
	public int insert(Emp emp) {
		int result=0;
		System.out.println("EmpDaoImpl insert start..");
		try {
			result = session.insert("insertEmp", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl insert Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int delete(int empno) {
		System.out.println("EmpDaoImpl delete start..");
		int result = 0;
		try {
			result = session.delete("delete", empno);  
			System.out.println("EmpDaoImpl delete result->"+result);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl delete Exception->"+e.getMessage());
		}
		return result;
	}
	
	@Override
	public List<EmpDept> listEmpDept() {
		System.out.println("EmpDaoImpl listEmpDept Start...");
		List<EmpDept> empDept = null;
		try {
			empDept = session.selectList("TKlistEmpDept");
			System.out.println("EmpDatoImpl listEmpDept empDept.size()->"+empDept.size());
		} catch (Exception e) {
			System.out.println("EmpDatoImpl delete Exception->"+e.getMessage());
		}
		return empDept;
	
	}
	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		System.out.println("EmpServiceImpl listEmp Start...");
		return session.selectList("TKlistEmpDept", empDept);
	}

}