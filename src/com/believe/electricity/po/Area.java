package com.believe.electricity.po;

import java.util.HashSet;
import java.util.Set;

public class Area
{
	private int id ; //id
	private String name ;  //区域名称
	
	//该区域所拥有的部门
	private Set<Department> departments = new HashSet<Department>() ;
	
	public Set<Department> getDepartments()
	{
		return departments;
	}
	public void setDepartments(Set<Department> departments)
	{
		this.departments = departments;
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
