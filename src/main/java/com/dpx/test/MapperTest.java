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
		
	//���뼸������
	//departmentMapper.insertSelective(new Department(null, "������"));
	//departmentMapper.insertSelective(new Department(null, "���Բ�"));
	
	//�����������
	/*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
	for (int i = 0; i < 100; i++) {
		String uid = UUID.randomUUID().toString().substring(0, 5)+i;
		mapper.insertSelective(new Employee(null, 1, uid, uid+"@163.com", "A"));
	}
	System.out.println("�ɹ�");*/
	
	//ɾ��������
	//employeeMapper.deleteByPrimaryKey(1);
	
	//�޸ı�����
	//employeeMapper.updateByPrimaryKey(new Employee(3, 1, "����", "����@163.com", "B"));
	
	 
	}
	

}
