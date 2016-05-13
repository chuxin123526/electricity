package com.believe.electricity.dao;

import java.util.Date;
import java.util.List;

import com.believe.electricity.po.Area;
import com.believe.electricity.po.User;

public interface IUserDao extends IBaseDao<User>
{
	public List<User> query(User user,int areaId , Date onDutyBegin , Date onDutyEnd) ;
}
