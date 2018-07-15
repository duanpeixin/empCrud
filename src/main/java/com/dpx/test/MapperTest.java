package com.dpx.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dpx.dao.DepartmentMapper;
import com.dpx.dao.EmployeeMapper;
import com.dpx.pojo.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper  departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void JDBCTest(){
	System.out.println(departmentMapper);
		
	//插入几个部门
	//departmentMapper.insertSelective(new Department(null, "开发部"));
	//departmentMapper.insertSelective(new Department(null, "测试部"));
	
	//插入多条数据
	/*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
	for (int i = 0; i < 100; i++) {
		String uid = UUID.randomUUID().toString().substring(0, 5)+i;
		mapper.insertSelective(new Employee(null, 1, uid, uid+"@163.com", "A"));
	}
	System.out.println("成功");*/
	
	//删除表数据
	//employeeMapper.deleteByPrimaryKey(1);
	
	//修改表数据
	//employeeMapper.updateByPrimaryKey(new Employee(3, 1, "王五", "王五@163.com", "B"));
	
	 
	}
	

}
