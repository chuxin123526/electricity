package com.believe.electricity.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.electricity.po.DataDictionaryProperty;
import com.believe.electricity.po.DataDictionaryType;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DataDictionaryAction extends BaseAction
{
	private DataDictionaryType dataDictionaryType ; 
	
	private String[] dataDictionaryPropertyNames ;
	
	/**
	 * 获取所有的数据类型
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception
	{
		//拿到所有的数据类型列表
	    List<DataDictionaryType> dataDictionaryTypeList = this.dataDictionaryTypeServiceImpl.list() ; 
	    
	    ActionContext.getContext().put("dataDictionaryTypeList", dataDictionaryTypeList);
	    
		return "list" ; 
	}
	
	/**
	 * 获取某数据类型下的所有属性
	 * @return
	 */
	public String edit() throws Exception
	{
		if(this.dataDictionaryType.getId() != 0)
		{
			//拿到数据库的类型对象
			this.dataDictionaryType = this.dataDictionaryTypeServiceImpl.findById(this.dataDictionaryType.getId()) ; 
			//拿到该类型下的所有属性
			List<DataDictionaryProperty> dataDictionaryPropertyList = new ArrayList<>(dataDictionaryType.getDataDictionaryPropertys()); 
			//放到栈顶
			ActionContext.getContext().put("dataDictionaryPropertyList", dataDictionaryPropertyList);
		}	
		
		return "edit" ; 
	}
	
	/**
	 * 保存数据字典
	 * @return
	 */
	public String save() throws Exception
	{
		if(this.dataDictionaryType.getId() != 0)
		{
			this.dataDictionaryType = this.dataDictionaryTypeServiceImpl.findById(this.dataDictionaryType.getId()) ; 
			Set<DataDictionaryProperty> set = new HashSet<>() ; 
			for(String name : this.dataDictionaryPropertyNames)
			{
				DataDictionaryProperty dataDictionaryProperty = new DataDictionaryProperty() ; 
				dataDictionaryProperty.setName(name);
				set.add(dataDictionaryProperty) ;
			}
			this.dataDictionaryType.setDataDictionaryPropertys(set);
			this.dataDictionaryTypeServiceImpl.update(this.dataDictionaryType);
		}
		return "toList" ;
	}
	
	
	
	public DataDictionaryType getDataDictionaryType()
	{
		return dataDictionaryType;
	}
	public void setDataDictionaryType(DataDictionaryType dataDictionaryType)
	{
		this.dataDictionaryType = dataDictionaryType;
	}

	public String[] getDataDictionaryPropertyNames()
	{
		return dataDictionaryPropertyNames;
	}

	public void setDataDictionaryPropertyNames(String[] dataDictionaryPropertyNames)
	{
		this.dataDictionaryPropertyNames = dataDictionaryPropertyNames;
	}
	
}
