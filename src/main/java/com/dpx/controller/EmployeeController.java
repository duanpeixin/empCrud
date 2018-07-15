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
	 * JSR303У��
	 */
	//����������Ϣ
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	@ResponseBody
	public Message saveEmps(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			//У��ʧ�ܷ��ش�����Ϣ
			Map<String ,Object> map = new HashMap<String, Object>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError error : fieldErrors) {
				System.out.println("������ֶ���"+error.getField());
                System.out.println("�������Ϣ"+error.getDefaultMessage());
                map.put(error.getField(),error.getDefaultMessage());
			}
			return Message.fali().add("errorMap", map);
		}else{			
			employeeService.saveEmployee(employee);
			return Message.success();
		}
		
	}
	
	/*
	 * �����û���
	 */
	@RequestMapping("/checkEmps")
	@ResponseBody
	public Message checkEmp(@RequestParam("empName") String empName){
		String regex = "(^[\u2E80-\u9FFF]+$)";
		if(!empName.matches(regex)){
			return Message.fali().add("error-mes", "������2-5�������ַ���");
		};
		boolean b =employeeService.chekcEmp(empName);
		if(b){
			return Message.success();
		}else{
			return Message.fali().add("error-mes", "�û����ظ�");
		}

	}
	//��ѯԱ��Id
	@RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Message getEmp(@PathVariable("id") Integer id){
        Employee emploee =employeeService.getEmpById(id);
        return Message.success().add("emp",emploee);
    }
	
	//����Ա��
	@RequestMapping(value = "/emps/{empId}",method = RequestMethod.PUT)
	@ResponseBody
	public Message saveEmp(Employee employee){
		employeeService.saveEmps(employee);
		return Message.success();
	}
	
	//����IDɾ������Ա��
	@RequestMapping(value= "/emps/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Message deleteEmp(@PathVariable("id") Integer id){
		employeeService.deleteEmpById(id);
		return Message.success();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��ѯԱ������
	//@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //1.����pageHelper

        //2.mybatis-configע��

        //3.��ѯ֮ǰֻ��Ҫ����,����ҳ�룬ÿҳ�Ĵ�С

        PageHelper.startPage(pn,5);

        //4.startPage��������Ĳ�ѯ��һ����ҳ��ѯ

        List<Employee> employeeList = employeeService.getAll();

        //5.ʹ��pageInfo��װ��ѯ��Ľ��������������ʾ��ҳ��

        PageInfo pageInfo = new PageInfo(employeeList,5);

        //6.��pageInfo����ҳ��

        //7.��װ����ϸ�ķ�ҳ��Ϣ��������ѯ��������Ϣ

        model.addAttribute("pageInfo",pageInfo);

        return "listEmp";
    }

}
