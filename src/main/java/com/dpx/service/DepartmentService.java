package com.dpx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpx.pojo.Department;
import com.dpx.pojo.DepartmentExample;

public interface DepartmentService {
	
	public List<Department> getDeps();
	
	long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer depId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer depId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

}
