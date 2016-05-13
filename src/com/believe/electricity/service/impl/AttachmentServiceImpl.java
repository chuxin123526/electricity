package com.believe.electricity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IAttachmentDao;
import com.believe.electricity.po.Attachment;
import com.believe.electricity.service.IAttachmentService;

@Service
@Transactional
public class AttachmentServiceImpl implements IAttachmentService
{
	@Resource
	private IAttachmentDao attachmentsDaoImpl ; 

	@Override
	public void add(Attachment entity) throws Exception
	{
		this.attachmentsDaoImpl.add(entity);
	}

	@Override
	public void delete(int id) throws Exception
	{
		this.attachmentsDaoImpl.deleteById(id);
	}

	@Override
	public void update(Attachment entity) throws Exception
	{
		this.attachmentsDaoImpl.update(entity);
	}

	@Override
	public Attachment findById(int id) throws Exception
	{
		return this.attachmentsDaoImpl.findById(id) ;
	}

	@Override
	public List<Attachment> list() throws Exception
	{
		return this.attachmentsDaoImpl.list() ;
	}

}
