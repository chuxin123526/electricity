package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IDepartmentDao;
import com.believe.electricity.po.Department;
import com.believe.electricity.service.IDepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService
{
	@Resource
	private IDepartmentDao departmentDaoImpl ; 

	@Override
	public void add(Department entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(int id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> list() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
