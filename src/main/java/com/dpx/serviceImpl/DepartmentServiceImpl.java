package com.dpx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpx.dao.DepartmentMapper;
import com.dpx.pojo.Department;
import com.dpx.pojo.DepartmentExample;
import com.dpx.service.DepartmentService;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDeps(){
		return this.departmentMapper.selectByExample(null);
	}
	

	public long countByExample(DepartmentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(DepartmentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(Integer depId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Department record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Department record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Department> selectByExample(DepartmentExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Department selectByPrimaryKey(Integer depId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Department record, DepartmentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Department record, DepartmentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Department record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Department record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
