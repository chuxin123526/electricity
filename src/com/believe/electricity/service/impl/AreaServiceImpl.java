package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IAreaDao;
import com.believe.electricity.po.Area;
import com.believe.electricity.service.IAreaService;

@Service
@Transactional
public class AreaServiceImpl implements IAreaService
{

	@Resource
	private IAreaDao areaDaoImpl ; 
	
	@Override
	public void add(Area entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Area entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Area findById(int id) throws Exception
	{
		return this.areaDaoImpl.findById(id) ; 
	}

	@Override
	public List<Area> list() throws Exception
	{
		return this.areaDaoImpl.list() ;
	}

}
