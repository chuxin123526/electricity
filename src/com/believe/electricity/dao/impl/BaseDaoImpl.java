package com.believe.electricity.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.believe.electricity.dao.IBaseDao;
import com.believe.electricity.utils.TUtil;


public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>
{ 
	Class entity = TUtil.getActualType(this.getClass()) ;
	
	
	@Resource
	public void setSessionFactoryDI(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(T entity) throws Exception
	{
		this.getHibernateTemplate().save(entity) ; 
	}

	
	@Override
	public void deleteById(int id) throws Exception
	{
		this.getHibernateTemplate().delete(this.findById(id));
	}

	@Override
	public void deleteByIds(int[] ids) throws Exception
	{
		if(ids != null && ids.length>0)
		{
			for(int id : ids)
			{
				this.deleteById(id);
			}
		}
	}

	@Override
	public void update(T entity) throws Exception
	{
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public List<T> list() throws Exception
	{
		String hql = "from " + this.entity.getSimpleName() ; 
		return this.getHibernateTemplate().find(hql) ; 
	}

	@Override
	public T findById(int id) throws Exception
	{
		return (T)this.getHibernateTemplate().load(this.entity, id) ; 
	}

}
