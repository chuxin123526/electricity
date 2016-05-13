package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IRoleDao;
import com.believe.electricity.po.Role;
import com.believe.electricity.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService
{
	@Resource
	private IRoleDao roleDaoImpl ; 

	@Override
	public void add(Role entity) throws Exception
	{
		this.roleDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.roleDaoImpl.deleteById(id);
	}

	@Override
	public void update(Role entity) throws Exception
	{
		this.roleDaoImpl.update(entity);
	}

	@Override
	public Role findById(int id) throws Exception
	{
		return this.roleDaoImpl.findById(id) ;
	}

	@Override
	public List<Role> list() throws Exception
	{
		return this.roleDaoImpl.list() ;
	}
	
}
