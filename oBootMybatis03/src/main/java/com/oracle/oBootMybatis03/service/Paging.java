package com.oracle.oBootMybatis03.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	private int currentPage = 1; 	private int rowPage = 10;
	private int pageBlock = 10;	    
	private int start; 				private int end;
	private int startPage; 			private int endPage;
	private int total;				private int totalPage;
	//                 42                2
	public Paging(int total, String currentPage1) {
		this.total = total;
		if (currentPage1 != null) {
			this.currentPage = Integer.parseInt(currentPage1);
		}
		start = (currentPage - 1) * rowPage + 1; //시작시1                  11
		end = start + rowPage -1 ; 				 //시작시 10                 20
		totalPage = (int)Math.ceil((double)total / rowPage );  //시작시 2        토탈 5페이지 
		             //  2             2           
		startPage = currentPage - (currentPage -1) % pageBlock; // 시작시1
		endPage = startPage + pageBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}
}
