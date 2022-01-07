package com.oracle.mvc.kkk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVC02Controller {

	private static final Logger logger = LoggerFactory.getLogger(MVC02Controller.class);
	
	@RequestMapping(value = "/board/view2")
	public String view2() {
		logger.info("MVC02Controller Logger board/view2 Start...");
		System.out.println("sysout /board/view2");
		
		return "board/view2";
	}
	
}
