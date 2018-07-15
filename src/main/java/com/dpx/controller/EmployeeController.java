package com.dpx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpx.dao.EmployeeMapper;
import com.dpx.pojo.Employee;
import com.dpx.service.EmployeeService;
import com.dpx.utils.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/emps")
	@ResponseBody
	public Message getEmpsWithJosn(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,5);

        List<Employee> employeeList = employeeService.getAll();

        PageInfo pageInfo = new PageInfo(employeeList,5);
        
        return Message.success().add("pageInfo", pageInfo);
	}
	
	/*
	 * JSR303校验
	 */
	//保存新增信息
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	@ResponseBody
	public Message saveEmps(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			//校验失败返回错误信息
			Map<String ,Object> map = new HashMap<String, Object>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError error : fieldErrors) {
				System.out.println("错误的字段名"+error.getField());
                System.out.println("错误的信息"+error.getDefaultMessage());
                map.put(error.getField(),error.getDefaultMessage());
			}
			return Message.fali().add("errorMap", map);
		}else{			
			employeeService.saveEmployee(employee);
			return Message.success();
		}
		
	}
	
	/*
	 * 检验用户名
	 */
	@RequestMapping("/checkEmps")
	@ResponseBody
	public Message checkEmp(@RequestParam("empName") String empName){
		String regex = "(^[\u2E80-\u9FFF]+$)";
		if(!empName.matches(regex)){
			return Message.fali().add("error-mes", "请输入2-5个中文字符！");
		};
		boolean b =employeeService.chekcEmp(empName);
		if(b){
			return Message.success();
		}else{
			return Message.fali().add("error-mes", "用户名重复");
		}

	}
	//查询员工Id
	@RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Message getEmp(@PathVariable("id") Integer id){
        Employee emploee =employeeService.getEmpById(id);
        return Message.success().add("emp",emploee);
    }
	
	//更新员工
	@RequestMapping(value = "/emps/{empId}",method = RequestMethod.PUT)
	@ResponseBody
	public Message saveEmp(Employee employee){
		employeeService.saveEmps(employee);
		return Message.success();
	}
	
	//根据ID删除单个员工
	@RequestMapping(value= "/emps/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Message deleteEmp(@PathVariable("id") Integer id){
		employeeService.deleteEmpById(id);
		return Message.success();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//查询员工数据
	//@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //1.引入pageHelper

        //2.mybatis-config注册

        //3.查询之前只需要调用,传入页码，每页的大小

        PageHelper.startPage(pn,5);

        //4.startPage后面紧跟的查询是一个分页查询

        List<Employee> employeeList = employeeService.getAll();

        //5.使用pageInfo包装查询后的结果，传入连续显示的页数

        PageInfo pageInfo = new PageInfo(employeeList,5);

        //6.把pageInfo交给页面

        //7.分装了详细的分页信息，包括查询出来的信息

        model.addAttribute("pageInfo",pageInfo);

        return "listEmp";
    }

}
