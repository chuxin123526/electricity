package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IDataDictionaryTypeDao;
import com.believe.electricity.po.DataDictionaryType;
import com.believe.electricity.service.IDataDictionaryTypeService;

@Service
@Transactional
public class DataDictionaryTypeServiceImpl implements IDataDictionaryTypeService
{
	@Resource
	private IDataDictionaryTypeDao dataDictionaryTypeDaoImpl ; 

	@Override
	public void add(DataDictionaryType entity) throws Exception
	{
		
	}

	@Override
	public void delete(int id) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DataDictionaryType entity) throws Exception
	{
		this.dataDictionaryTypeDaoImpl.update(entity);
	}

	@Override
	public DataDictionaryType findById(int id) throws Exception
	{
		return this.dataDictionaryTypeDaoImpl.findById(id) ; 
	}

	@Override
	public List<DataDictionaryType> list() throws Exception
	{
		return this.dataDictionaryTypeDaoImpl.list() ; 
	}

}
