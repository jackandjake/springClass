package com.oracle.oBootMybatis03.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.DeptVO;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("DeptDaoImpl deptSelect start...");
		//deptList = session.selectList("TKselectDept");
		//System.out.println("DeptDaoImple deptSelect deptList.size()->" +deptList.size());
		try {
			deptList = session.selectList("TKselectDept");
		} catch (Exception e) {
				System.out.println("DeptDaoImpl deptSelect Exception->"+e.getMessage());
		}
		System.out.println("DeptDaoImpl deptSelect deptList.size()->"+deptList.size());
		return deptList;

	}

	@Override
	public void insertDept(DeptVO deptVO) {
		System.out.println("DeptDaoImple insertDept Start...");
		session.selectOne("ProcDept", deptVO);
	}

	@Override
	public void selListDept(HashMap<String, Object> map) {
		System.out.println("DeptDaoImpl selListDept Start...");
		session.selectOne("ProcDeptList", map);
		
	}

	
	
}
