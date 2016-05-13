package com.believe.electricity.po;

import java.util.Date;

public class BaseMessage
{
	private int id ; 
	private String stationRunCondition ; 
	private String equipmentRunCondition ; 
	private Date createDate ;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getStationRunCondition()
	{
		return stationRunCondition;
	}
	public void setStationRunCondition(String stationRunCondition)
	{
		this.stationRunCondition = stationRunCondition;
	}
	public String getEquipmentRunCondition()
	{
		return equipmentRunCondition;
	}
	public void setEquipmentRunCondition(String equipmentRunCondition)
	{
		this.equipmentRunCondition = equipmentRunCondition;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	
	
}
