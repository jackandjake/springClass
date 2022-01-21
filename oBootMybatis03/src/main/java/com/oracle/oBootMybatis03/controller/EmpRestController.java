package com.oracle.oBootMybatis03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.oBootMybatis03.model.Dept;
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
		
		@RequestMapping("/sendV03")
		public List<Dept> sendV03() {
			System.out.println("@RestController sendV03 START");
			List<Dept> deptList = es.deptSelect();
			return deptList;
		}
	
}
