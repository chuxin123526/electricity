package com.believe.electricity.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.electricity.po.Privilege;
import com.believe.electricity.po.Role;
import com.believe.electricity.po.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction
{
	private Role role ; //角色
	private int[] privilegeIDS ; //接受前台传过来的权限id数组
	private int[] userIDS ; //接受前台传过来的用户id数组
	
	
	/**
	 * 角色管理首页
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception
	{
		//准备所有的角色
		List<Role> roleList = this.roleServiceImpl.list() ; 
		ActionContext.getContext().put("roleList" , roleList);
		
		//准备所有的顶级权限
		List<Privilege> topPrivilegeList = this.privilegeServiceImpl.findTopPrivilegeList() ;	
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		
		//准备所有用户
		List<User> userList = this.userServiceImpl.list() ; 
		ActionContext.getContext().put("userList", userList);
		
		
		
		return "index" ;
	}
	
	/**
	 *更改role
	 */
	public String changeRole() throws Exception
	{
		//根据角色id拿到角色
		this.role = this.roleServiceImpl.findById(this.role.getId()) ;
		ActionContext.getContext().put("role", this.role);
		
		//准备所有的顶级权限
		List<Privilege> topPrivilegeList = this.privilegeServiceImpl.findTopPrivilegeList() ;	
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		
		//准备所有用户
		List<User> userList = this.userServiceImpl.list() ; 
		ActionContext.getContext().put("userList", userList);
		
		
		return "changeRole" ;
	}
	
	
	/**
	 * 分配权限
	 */
	public String allocatePrivilege() throws Exception
	{
		if(this.role.getId() != 0)
		{
			//根据角色id拿到角色实体
			this.role = this.roleServiceImpl.findById(this.role.getId()) ; 
			
			//根据权限id数组构建set集合
			Set<Privilege> privilegeSet = new HashSet<Privilege>() ; 
			if(this.privilegeIDS != null)
			{
				for(int id : this.privilegeIDS)
				{
					Privilege privilege = this.privilegeServiceImpl.findById(id) ;
					privilegeSet.add(privilege) ;
				}
			}
			
			//设置角色与权限的对应关系
			this.role.setPrivileges(privilegeSet);
			
			//根据用户id数组构建集合
			Set<User> userSet = new HashSet<User>() ; 
			if(this.userIDS != null)
			{
				for(int id : this.userIDS)
				{
					User user = this.userServiceImpl.findById(id) ;
					userSet.add(user) ;
				}
			}
			//设置角色与用户的关系
			this.role.setUsers(userSet);
			
			//修改
			this.roleServiceImpl.update(this.role) ;		
		}
		
		return "toIndex" ;
	}
	
	
	

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public int[] getPrivilegeIDS()
	{
		return privilegeIDS;
	}

	public void setPrivilegeIDS(int[] privilegeIDS)
	{
		this.privilegeIDS = privilegeIDS;
	}

	public int[] getUserIDS()
	{
		return userIDS;
	}

	public void setUserIDS(int[] userIDS)
	{
		this.userIDS = userIDS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
