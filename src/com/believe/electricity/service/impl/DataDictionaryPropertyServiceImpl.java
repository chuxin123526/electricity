package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IDataDictionaryPropertyDao;
import com.believe.electricity.po.DataDictionaryProperty;

@Service
@Transactional
public class DataDictionaryPropertyServiceImpl implements IDataDictionaryPropertyDao
{

	@Resource
	private IDataDictionaryPropertyDao dataDictionaryPropertyDaoImpl ;
	
	@Override
	public void add(DataDictionaryProperty entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByIds(int[] ids) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DataDictionaryProperty entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataDictionaryProperty> list() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataDictionaryProperty findById(int id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
