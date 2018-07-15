package com.dpx.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockSessionCookieConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dpx.pojo.Employee;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PageTest {
	@Autowired
	//����smpringmvc��ioc
	WebApplicationContext context;
	//����mvc����
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc(){		
		 mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception{
		//ģ�������õ��ķ���ֵ
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/emp").param("pn","4")).andReturn();;
		
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo) request.getAttribute("PageInfo");
		System.out.println("��ǰҳ��:" + pi.getPageNum());
        System.out.println("��ҳ��:" + pi.getPages());
        System.out.println("�ܼ�¼��:" + pi.getTotal());
        System.out.println("������ʾ��ҳ��:");
        int[] nums = pi.getNavigatepageNums();
        for (int i : nums){
            System.out.print(" " + i);
        }
		
		//��ȡԱ������
		List<Employee> list = pi.getList();
		for (Employee employee : list) {
			System.out.println("ID="+employee.getEmpId()+"name="+employee.getEmpName());
		}
	}

}
