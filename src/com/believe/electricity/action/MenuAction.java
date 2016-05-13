package com.believe.electricity.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.electricity.po.BaseMessage;
import com.believe.electricity.po.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class MenuAction extends BaseAction
{
	/**
	 * 跳转到首页
	 */
	public String home() throws Exception
	{
		return "home" ; 
	}
	
	/**
	 * 准备首页顶部
	 * @return
	 * @throws Exception
	 */
	public String top() throws Exception 
	{
		return "top" ; 
	}
	
	/**
	 * 首页左侧
	 */
	public String left() throws Exception
	{
		return "left" ; 
	}
	
	/**
	 *首页状态改变栏 
	 */
	public String change() throws Exception
	{
		return "change" ;
	}
	
	/**
	 * 首页主体
	 */
	public String loading() throws Exception
	{
		return "loading" ; 
	}
	
	/**
	 * 获取站点运行情况
	 */
	public String stationRunCondition() throws Exception
	{
		List<BaseMessage> baseMessageList = this.baseMessageServiceImpl.list() ;
		BaseMessage baseMessage = null; 
		//如果存在该记录
		if(baseMessageList != null && baseMessageList.size() > 0)
		{
			baseMessage = baseMessageList.get(0) ; 
		}
		//如不存在该记录，则创建一条记录
		else
		{
			baseMessage = new BaseMessage() ;
			baseMessage.setCreateDate(new Date());
		}
		ActionContext.getContext().put("baseMessage", baseMessage);
		
		return "stationRunCondition" ;
	}
	
	/**
	 * 获取设备运行情况
	 */
	public String equipmentRunCondition() throws Exception
	{
		List<BaseMessage> baseMessageList = this.baseMessageServiceImpl.list() ; 
		BaseMessage baseMessage = null; 
		//如果存在该记录
		if(baseMessageList != null && baseMessageList.size() > 0)
		{
			baseMessage = baseMessageList.get(0) ; 
		}
		//如不存在该记录，则创建一条记录
		else
		{
			baseMessage = new BaseMessage() ;
			baseMessage.setCreateDate(new Date());
		}
		ActionContext.getContext().put("baseMessage", baseMessage);
		
		return "equipmentRunCondition" ; 
	}
}
