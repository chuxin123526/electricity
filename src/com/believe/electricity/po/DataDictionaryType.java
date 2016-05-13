package com.believe.electricity.po;

import java.util.HashSet;
import java.util.Set;

public class DataDictionaryType
{
	private int id ; //id 
	private String name ; //名称
	
	//该数据类型所拥有的属性
	private Set<DataDictionaryProperty> dataDictionaryPropertys = new HashSet<DataDictionaryProperty>() ; 
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Set<DataDictionaryProperty> getDataDictionaryPropertys()
	{
		return dataDictionaryPropertys;
	}
	public void setDataDictionaryPropertys(Set<DataDictionaryProperty> dataDictionaryPropertys)
	{
		this.dataDictionaryPropertys = dataDictionaryPropertys;
	}
	
	
}
