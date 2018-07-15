package com.dpx.serviceImpl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.stereotype.Service;

import com.dpx.dao.EmployeeMapper;
import com.dpx.pojo.Employee;
import com.dpx.pojo.EmployeeExample;
import com.dpx.pojo.EmployeeExample.Criteria;
import com.dpx.service.EmployeeService;
import com.dpx.utils.Message;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService, EmbeddedDatabase {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

	public long countByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(Integer empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Employee> selectByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee selectByPrimaryKey(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> selectByExampleWithDep(EmployeeExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee selectByPrimaryKeyWithDep(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Employee record, EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Employee record, EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}
    //查询所有员工
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDep(null);
	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeMapper.insertSelective(employee);
	}

	public boolean chekcEmp(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}
    //根据ID查员工
	public Employee getEmpById(Integer id) {
		// TODO Auto-generated method stub
		
		return employeeMapper.selectByPrimaryKey(id);
	}
    //更新员工方法
	public void saveEmps(Employee employee) {
		// TODO Auto-generated method stub
		 employeeMapper.updateByPrimaryKeySelective(employee);
	}
    //删除单个员工
	public void deleteEmpById(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

}
