package com.believe.electricity.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.electricity.po.BaseMessage;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class BaseMessageAction extends BaseAction
{	
	private BaseMessage baseMessage ; 
	
	/**
	 * 获取监控数据的基本数据
	 */
	public String info() throws Exception
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
		
		return "info" ; 
	}
	
	/**
	 * 保存监控数据
	 */
	public String save() throws Exception
	{
		this.baseMessageServiceImpl.update(this.baseMessage);
		
		return "to_info" ; 
	}
}
