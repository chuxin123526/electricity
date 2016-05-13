package com.believe.electricity.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IUserDao;
import com.believe.electricity.po.Area;
import com.believe.electricity.po.User;
import com.believe.electricity.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
	@Resource
	private IUserDao userDaoImpl ;

	@Override
	public void add(User entity) throws Exception
	{
		this.userDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.userDaoImpl.deleteById(id);
	}

	@Override
	public void update(User entity) throws Exception
	{
		this.userDaoImpl.update(entity);
	}

	@Override
	public User findById(int id) throws Exception
	{
		return this.userDaoImpl.findById(id) ;
	}

	@Override
	public List<User> list() throws Exception
	{
		return this.userDaoImpl.list() ;
	}

	@Override
	public List<User> query(User user , int areaId, Date onDutyBegin, Date onDutyEnd)
	{
		return this.userDaoImpl.query(user, areaId, onDutyBegin, onDutyEnd) ;
	}
	
}
