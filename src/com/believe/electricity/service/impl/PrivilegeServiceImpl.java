package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IPrivilegeDao;
import com.believe.electricity.po.Privilege;
import com.believe.electricity.service.IPrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl implements IPrivilegeService
{
	@Resource
	private IPrivilegeDao privilegeDaoImpl ; 

	@Override
	public void add(Privilege entity) throws Exception
	{
		this.privilegeDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.privilegeDaoImpl.deleteById(id);
	}

	@Override
	public void update(Privilege entity) throws Exception
	{
		this.privilegeDaoImpl.update(entity);
	}

	@Override
	public Privilege findById(int id) throws Exception
	{
		return this.privilegeDaoImpl.findById(id) ;
	}

	@Override
	public List<Privilege> list() throws Exception
	{
		return this.privilegeDaoImpl.list() ;
	}

	@Override
	public List<Privilege> findTopPrivilegeList() throws Exception
	{
		return this.privilegeDaoImpl.findAllTopPrivilege() ;
	}
	
}
