package com.believe.electricity.po;

public class Attachment
{
	private int id ; 
	private String name ; 
	private String path ;
	
	//该附件所属用户
	private User user ; 
	
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
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
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	} 
	
	
	
}
