package com.believe.electricity.utils;

import java.lang.reflect.ParameterizedType;

public class TUtil
{
	public static Class getActualType(Class clazz)
	{
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityClass;
	}
}
