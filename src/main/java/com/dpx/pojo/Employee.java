package com.dpx.pojo;

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer empId;

    private Integer dId;
    @Pattern(regexp="^[\\u2E80-\\u9FFF]+$",message="请输入2-5个中文字符！")
    private String empName;
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message="输入邮箱格式错误！")
    private String empMail;

    private String empGrade;
    
    private Department department;
    
    
    

    @Override
	public String toString() {
		return "Employee [empId=" + empId + ", dId=" + dId + ", empName=" + empName + ", empMail=" + empMail
				+ ", empGrade=" + empGrade + ", department=" + department + "]";
	}

	public Employee(Integer empId, Integer dId, String empName, String empMail, String empGrade
			) {
		super();
		this.empId = empId;
		this.dId = dId;
		this.empName = empName;
		this.empMail = empMail;
		this.empGrade = empGrade;
		
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpMail() {
        return empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail == null ? null : empMail.trim();
    }

    public String getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(String empGrade) {
        this.empGrade = empGrade == null ? null : empGrade.trim();
    }
}