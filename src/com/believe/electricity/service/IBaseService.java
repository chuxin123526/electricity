package com.believe.electricity.service;

import java.util.List;

public interface IBaseService<T>
{
	public void add(T entity) throws Exception; 
	public void delete(int id) throws Exception; 
	public void update(T entity) throws Exception ; 
	public T findById(int id) throws Exception ; 
	public List<T> list() throws Exception ; 
}
