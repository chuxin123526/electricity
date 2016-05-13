package com.believe.electricity.po;

import java.util.HashSet;
import java.util.Set;

public class Role
{
	private int id ; //id 
	private String name ; //名称
	
	private Set<User> users = new HashSet<User>() ; //该角色所拥有的用户
	private Set<Privilege> privileges = new HashSet<Privilege>() ; //该角色所拥有的权限
	
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
	public Set<User> getUsers()
	{
		return users;
	}
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
	public Set<Privilege> getPrivileges()
	{
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges)
	{
		this.privileges = privileges;
	}
	
	
	
	
	
	
	
}
