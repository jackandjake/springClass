package com.oracle.oBootMybatis03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.SampleVO;
import com.oracle.oBootMybatis03.service.EmpService;
// @Controller + @ResponseBody
@RestController
public class EmpRestController {
	
	@Autowired
	private EmpService es;
	
	@RequestMapping("/helloText")
	public String helloText() {
		System.out.println("EmpRestController Start...");
		String hello = "안녕";
		return hello;
	}
	
	@RequestMapping("/sample/sendVO2")
	public SampleVO sendVO2(int deptno) {
		System.out.println("@RestController deptno->"+deptno);
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(deptno);
		return vo;
	}
	
	    // http://jsonviewer.stack.hu/
		@RequestMapping("/sendVO3")
		public List<Dept> sendVO3() {
			System.out.println("@RestController sendVO3 START");
			List<Dept> deptList = es.deptSelect();
			return deptList;
		}
	
// 
		@RequestMapping("/empnoDelete")
		//public String empnoDelete(int empno, String ename) { 두개이상이면 이렇게 받거나
		public String empnoDelete(Emp emp) {  // 아예 객체로 받으면 됨
			System.out.println("@RestController empnoDelete START");
			System.out.println("@RestController empnoDelete emp.getEname()->" + emp.getEname());
			int delStatus = es.delete(emp.getEmpno());
			String delStatusStr = Integer.toString(delStatus);
			return delStatusStr;	
		}
		
		
		
		
}
