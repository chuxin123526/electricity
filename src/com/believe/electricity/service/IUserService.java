package com.believe.electricity.service;

import java.util.Date;
import java.util.List;

import com.believe.electricity.po.Area;
import com.believe.electricity.po.User;

public interface IUserService extends IBaseService<User>
{
	public List<User> query(User user , int areaId , Date onDutyBegin , Date onDutyEnd) ;
}
