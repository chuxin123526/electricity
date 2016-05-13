package com.believe.electricity.action;

import javax.annotation.Resource;

import com.believe.electricity.dao.IDataDictionaryPropertyDao;
import com.believe.electricity.service.IAreaService;
import com.believe.electricity.service.IAttachmentService;
import com.believe.electricity.service.IBaseMessageService;
import com.believe.electricity.service.IDataDictionaryTypeService;
import com.believe.electricity.service.IPrivilegeService;
import com.believe.electricity.service.IRoleService;
import com.believe.electricity.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport
{
	@Resource
	protected IBaseMessageService baseMessageServiceImpl ; 
	
	@Resource
	protected IDataDictionaryTypeService dataDictionaryTypeServiceImpl ; 
	
	@Resource
	protected IDataDictionaryPropertyDao dataDictionaryPropertyServiceImpl ;

	@Resource
	protected IUserService userServiceImpl ;
	
	@Resource
	protected IAttachmentService attachmentServiceImpl ;
	
	@Resource
	protected IAreaService areaServiceImpl ;
	
	@Resource
	protected IRoleService roleServiceImpl ; 
	
	@Resource
	protected IPrivilegeService privilegeServiceImpl ;
	
}
