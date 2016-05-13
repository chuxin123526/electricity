package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IBaseMessageDao;
import com.believe.electricity.po.BaseMessage;
import com.believe.electricity.service.IBaseMessageService;

@Service
@Transactional
public class BaseMessageServiceImpl implements IBaseMessageService
{
	@Resource(name="baseMessageDaoImpl")
	private IBaseMessageDao baseMessageDaoImpl ;
	
	@Override
	public void add(BaseMessage entity) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BaseMessage entity) throws Exception
	{
		//拿到数据库中的监控数据
		List<BaseMessage> baseMessageList = this.baseMessageDaoImpl.list() ; 
		BaseMessage baseMessage = null ; 
		
		//如果数据库中有该记录
		if(baseMessageList != null && baseMessageList.size() >0)
		{
			baseMessage = baseMessageList.get(0) ; 
			//修改数据
			baseMessage.setStationRunCondition(entity.getStationRunCondition());
			baseMessage.setEquipmentRunCondition(entity.getEquipmentRunCondition());
		}
		//如果数据库中没有改记录
		else
		{
			this.baseMessageDaoImpl.add(entity);
		}
		
		
	}

	@Override
	public BaseMessage findById(int id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseMessage> list() throws Exception
	{
		return this.baseMessageDaoImpl.list() ; 
	}
	
}
