package com.believe.electricity.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.believe.electricity.dao.IPrivilegeDao;
import com.believe.electricity.po.Privilege;

@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao
{

	@Override
	public List<Privilege> findAllTopPrivilege() throws Exception
	{
		String hql = "from Privilege p where p.parent is null" ; 
		List<Privilege> TopPrivilegeList = this.getHibernateTemplate().find(hql) ; 
		
		return TopPrivilegeList ;
	}
	
}
