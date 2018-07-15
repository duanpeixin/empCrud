package com.dpx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpx.pojo.Department;
import com.dpx.service.DepartmentService;
import com.dpx.utils.Message;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/deps")
	@ResponseBody
	public Message getDeps(){
		List<Department> list = departmentService.getDeps();
		return Message.success().add("Deps", list);
	}

}
