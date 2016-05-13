package com.believe.electricity.dao;

import java.util.List;

import com.believe.electricity.po.Privilege;

public interface IPrivilegeDao extends IBaseDao<Privilege>
{
	public List<Privilege> findAllTopPrivilege() throws Exception ; 
}
