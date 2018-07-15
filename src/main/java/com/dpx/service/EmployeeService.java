package com.dpx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpx.pojo.Employee;
import com.dpx.pojo.EmployeeExample;
import com.dpx.utils.Message;

public interface EmployeeService {
	    long countByExample(EmployeeExample example);

	    int deleteByExample(EmployeeExample example);

	    int deleteByPrimaryKey(Integer empId);

	    int insert(Employee record);

	    int insertSelective(Employee record);

	    List<Employee> selectByExample(EmployeeExample example);

	    Employee selectByPrimaryKey(Integer empId);
	    
	    List<Employee> selectByExampleWithDep(EmployeeExample example);

	    Employee selectByPrimaryKeyWithDep(Integer empId);

	    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

	    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

	    int updateByPrimaryKeySelective(Employee record);

	    int updateByPrimaryKey(Employee record);
	    
	     List<Employee> getAll();

		void saveEmployee(Employee employee);

		boolean chekcEmp(String empName);

		Employee getEmpById(Integer id);

		void saveEmps(Employee employee);

		void deleteEmpById(Integer id);

	

}
