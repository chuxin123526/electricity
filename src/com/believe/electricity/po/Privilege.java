package com.believe.electricity.po;

import java.util.HashSet;
import java.util.Set;

public class Privilege
{
	private int id ; 
	private String name ; //名称
	private String url ; //权限的访问路径
	private boolean isParent ; //是否是父级权限
	private boolean isMenu ; //是否是菜单
	private String icon ; //如果是菜单，则为显示图片的url
	
	private Privilege parent ; //父级权限
	private Set<Privilege> privileges = new HashSet<Privilege>() ; //该权限的下级权限
	private Set<Role> roles = new HashSet<Role>() ; //该权限所拥有的角色
	
	
	public Set<Privilege> getPrivileges()
	{
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges)
	{
		this.privileges = privileges;
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
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public boolean getIsParent()
	{
		return isParent;
	}
	public void setIsParent(boolean isParent)
	{
		this.isParent = isParent;
	}
	public boolean getIsMenu()
	{
		return isMenu;
	}
	public void setIsMenu(boolean isMenu)
	{
		this.isMenu = isMenu;
	}
	
	public String getIcon()
	{
		return icon;
	}
	public void setIcon(String icon)
	{
		this.icon = icon;
	}
	public Privilege getParent()
	{
		return parent;
	}
	public void setParent(Privilege parent)
	{
		this.parent = parent;
	}
	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
	
	
	
}
