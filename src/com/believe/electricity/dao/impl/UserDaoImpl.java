package com.believe.electricity.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.believe.electricity.dao.IUserDao;
import com.believe.electricity.po.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao
{

	@Override
	public List<User> query(User user,int areaId ,  Date onDutyBegin, Date onDutyEnd)
	{
		String hql = "from User u" ; 
		if(user!=null && user.getName() != null)
		{
			hql+=" where u.name like '%"+user.getName() +"%'" ;
		}
		if(areaId != 0)
		{
			hql+= " and u.area.id="+areaId ;
		}
		if(onDutyBegin != null)
		{
			Long time = onDutyBegin.getTime() ;
			hql+= " and u.onDutyDate>="+time ;
		}
		if(onDutyEnd != null)
		{
			Long time = onDutyEnd.getTime() ;
			hql += " and u.onDutyDate<="+time ;
		}
		System.out.println(hql);
		System.out.println("------------------");
		List<User> userList = this.getHibernateTemplate().find(hql) ;
		System.out.println(userList.size());
		return userList ;
	}

}
