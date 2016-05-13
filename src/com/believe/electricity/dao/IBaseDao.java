package com.believe.electricity.dao;

import java.util.List;

public interface IBaseDao<T>
{
	public void add(T entity) throws Exception ; 
	public void deleteById(int id) throws Exception ; 
	public void deleteByIds(int[] ids) throws Exception ; 
	public void update(T entity) throws Exception ; 
	public List<T> list() throws Exception ; 
	public T findById(int id) throws Exception ; 
}
