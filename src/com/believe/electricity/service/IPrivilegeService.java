package com.believe.electricity.service;

import java.util.List;

import com.believe.electricity.po.Privilege;

public interface IPrivilegeService extends IBaseService<Privilege>
{
	public List<Privilege> findTopPrivilegeList() throws Exception ; 
}
