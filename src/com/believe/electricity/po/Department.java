package com.believe.electricity.po;

public class Department
{
	private int id ; //id
	private String name ; //部门名称
	
	//该部门所在区域
	private Area area ;
	
	
	
	public Area getArea()
	{
		return area;
	}
	public void setArea(Area area)
	{
		this.area = area;
	}
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
	
	
}
