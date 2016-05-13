package com.believe.electricity.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User
{
	private int id ; 
	private String name ; 
	private String loginName ; 
	private String password ; 
	private String sex ; 
	private Date birthDate ; 
	private String address ; 
	private String contactTelephone ; 
	private String mobilePhone ; 
	private String email ;
	private String isDuty ; //是否在职
	private Date onDutyDate ; //入职时间
	private Date offDutyDate ; //离职时间
	private String remark ; 
	private String position ; 

	private String unit ; //用户所在单位名称
	
	private Area area ; //用户所在区域
	
	private Department department ; //用户所在部门
	
	//用户上传的附件
	private Set<Attachment> attachmentss = new HashSet<Attachment>() ; 
	
	//用户所拥有的角色
	private Set<Role> roles = new HashSet<Role>() ;
	
	
	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
	public Department getDepartment()
	{
		return department;
	}
	public void setDepartment(Department department)
	{
		this.department = department;
	}
	public Set<Attachment> getAttachmentss()
	{
		return attachmentss;
	}
	public void setAttachmentss(Set<Attachment> attachmentss)
	{
		this.attachmentss = attachmentss;
	}
	public String getPosition()
	{
		return position;
	}
	public void setPosition(String position)
	{
		this.position = position;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getLoginName()
	{
		return loginName;
	}
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public Date getBirthDate()
	{
		return birthDate;
	}
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getContactTelephone()
	{
		return contactTelephone;
	}
	public void setContactTelephone(String contactTelephone)
	{
		this.contactTelephone = contactTelephone;
	}
	public String getMobilePhone()
	{
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getIsDuty()
	{
		return isDuty;
	}
	public void setIsDuty(String isDuty)
	{
		this.isDuty = isDuty;
	}
	public Date getOnDutyDate()
	{
		return onDutyDate;
	}
	public void setOnDutyDate(Date onDutyDate)
	{
		this.onDutyDate = onDutyDate;
	}
	public Date getOffDutyDate()
	{
		return offDutyDate;
	}
	public void setOffDutyDate(Date offDutyDate)
	{
		this.offDutyDate = offDutyDate;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	public Area getArea()
	{
		return area;
	}
	public void setArea(Area area)
	{
		this.area = area;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setUnit(String unit)
	{
		this.unit = unit;
	}


	
	
}
