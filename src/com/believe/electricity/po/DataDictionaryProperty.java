package com.believe.electricity.po;

public class DataDictionaryProperty
{
	private int id ; //id
	private String name ; //名称
	
	//该属性所属的数据类型
	private DataDictionaryType dataDictionaryType ;
	
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
	public DataDictionaryType getDataDictionaryType()
	{
		return dataDictionaryType;
	}
	public void setDataDictionaryType(DataDictionaryType dataDictionaryType)
	{
		this.dataDictionaryType = dataDictionaryType;
	} 
	
	
}
