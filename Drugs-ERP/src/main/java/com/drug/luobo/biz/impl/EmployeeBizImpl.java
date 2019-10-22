package com.drug.luobo.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.EmployeeBiz;
import com.drug.luobo.entity.Employee;
import com.drug.luobo.mapper.EmployeeMapper;
@Service
public class EmployeeBizImpl implements EmployeeBiz {
    @Autowired
	private EmployeeMapper mapper;
	@Override
	public Employee longin(Employee employee) {
		return mapper.login(employee);
	}

}
