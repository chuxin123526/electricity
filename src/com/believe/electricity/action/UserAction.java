package com.believe.electricity.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.believe.electricity.po.Area;
import com.believe.electricity.po.Attachment;
import com.believe.electricity.po.Department;
import com.believe.electricity.po.User;
import com.believe.electricity.utils.TFile;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction
{	
	private User user ; 
	
	//上传的文件
	private File[] uploads ; 
	//上传的文件名
	private String[] uploadsFileName ; 
	//上传的文件类型
	private String[] uploadsContextYype ; 
	
	//下载的附件id
	private int fileID ; 
	//下载的文件名
	private String fileName ;
	//下载的输入流
	private InputStream inputStream ; 
	
	//需要删除的用户id数组
	private int[] userIDS ; 
	
	//1.ajax传过来的区域id ， 获取部门 , 2.用于查询用户
	private int areaId ; 
	
	//查询用户条件
	private Date onDutyBegin ; //入职开始最早时间
	private Date onDutyEnd ; //入职开始最迟时间
	
	
	/**
	 * 跳转到登录界面
	 * @return
	 * @throws Exception
	 */
	public String loginUI() throws Exception
	{
		return "loginUI" ; 
	}
	
	/**
	 * 登录，转发action
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception
	{
		return "to_home" ; 
	}
	
	/**
	 * 拿到用户列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception
	{
		//拿到用户列表
		List<User> userList = this.userServiceImpl.list() ;
		ActionContext.getContext().put("userList", userList);
		
		//拿到区域列表，用于查询
		List<Area> areaList = this.areaServiceImpl.list() ;
		ActionContext.getContext().put("areaList", areaList);
		
		return "list" ;
	}
	
	
	/**
	 * 跳转到添加用户界面
	 * @return
	 */
	public String add() throws Exception
	{
		//拿到区域列表
		List<Area> areaList = this.areaServiceImpl.list() ; 
		ActionContext.getContext().put("areaList", areaList);
		
		return "add" ;
	}
	
	/**
	 * 添加用户，然后跳转到用户列表页面
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		//如果用户有上传附件
		if(this.uploads != null)
		{
			Set<Attachment> userAttachmentSet = new HashSet<Attachment>() ;
			for(int i = 0 ; i < this.uploads.length ; i++)
			{
				String basePath = ServletActionContext.getServletContext().getRealPath("/uploads") ;
				String path = TFile.saveFile(this.uploads[i], this.uploadsFileName[i], basePath) ;
				Attachment attachment = new Attachment() ; 
				attachment.setName(uploadsFileName[i]);
				attachment.setPath(path);
				userAttachmentSet.add(attachment) ; 
				
			}
			this.user.setAttachmentss(userAttachmentSet);
		}
			
		//保存用户
		this.userServiceImpl.add(this.user);
		
		return "close" ; 
	}
	
	/**
	 * 编辑用户
	 * @return
	 */
	public String edit() throws Exception
	{
		//根据id获取用户对象
		this.user = this.userServiceImpl.findById(this.user.getId()) ; 
		
		return "edit" ;
	}
	
	/**
	 * 附件下载
	 * @return
	 */
	public String download() throws Exception
	{
		//根据文件id找到附件对象
		Attachment attachment = this.attachmentServiceImpl.findById(this.fileID) ; 
		//复制文件名
		this.fileName = attachment.getName() ; 
		//给文件名编码,用于修复中文不显示
		this.fileName = new String(this.fileName.getBytes() , "ISO-8859-1") ;
		//打开输入流
		this.inputStream = new FileInputStream(attachment.getPath()) ; 
		
		return "download" ; 
	}
	
	/**
	 * 批量删除用户
	 * @return
	 */
	public String delete() throws Exception
	{
		//循环userIDS删除用户
		for(int id : this.userIDS)
		{
			this.userServiceImpl.delete(id);
		}
		
		return "toList" ;
	}
	
	/**
	 * ajax根据区域id获取部门
	 * @return
	 */
	public String getDepartmentByAreaId() throws Exception
	{
		//根据区域id获取部门
		Area area = this.areaServiceImpl.findById(this.areaId) ; 
		Set<Department> departments = area.getDepartments() ; 
		List<Department> departmentList = new ArrayList<Department>(departments) ;
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "getDepartmentByAreaId" ;
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String query() throws Exception
	{

		//拿到区域列表
		List<Area> areaList = this.areaServiceImpl.list() ; 
		ActionContext.getContext().put("areaList", areaList);
		
		List<User> userList = this.userServiceImpl.query(this.user, this.areaId, onDutyBegin, onDutyEnd) ;
		ActionContext.getContext().put("userList", userList);
		
		return "list" ; 
	}
	
	

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public File[] getUploads()
	{
		return uploads;
	}

	public void setUploads(File[] uploads)
	{
		this.uploads = uploads;
	}

	public String[] getUploadsFileName()
	{
		return uploadsFileName;
	}

	public void setUploadsFileName(String[] uploadsFileName)
	{
		this.uploadsFileName = uploadsFileName;
	}

	public String[] getUploadsContextYype()
	{
		return uploadsContextYype;
	}

	public void setUploadsContextYype(String[] uploadsContextYype)
	{
		this.uploadsContextYype = uploadsContextYype;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public void setInputStream(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}

	public int getFileID()
	{
		return fileID;
	}

	public void setFileID(int fileID)
	{
		this.fileID = fileID;
	}

	public int[] getUserIDS()
	{
		return userIDS;
	}

	public void setUserIDS(int[] userIDS)
	{
		this.userIDS = userIDS;
	}

	public int getAreaId()
	{
		return areaId;
	}

	public void setAreaId(int areaId)
	{
		this.areaId = areaId;
	}

	public Date getOnDutyBegin()
	{
		return onDutyBegin;
	}

	public void setOnDutyBegin(Date onDutyBegin)
	{
		this.onDutyBegin = onDutyBegin;
	}

	public Date getOnDutyEnd()
	{
		return onDutyEnd;
	}

	public void setOnDutyEnd(Date onDutyEnd)
	{
		this.onDutyEnd = onDutyEnd;
	}

	
	
}
