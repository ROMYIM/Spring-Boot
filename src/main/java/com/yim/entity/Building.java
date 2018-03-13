package com.yim.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Building对象", description = "楼宇对象")
public class Building {
	@ApiModelProperty(value = "楼宇号码", name = "buildingNum", dataType = "String", required = true)
	private String buildingNum;
	
	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Building(String buildingNum) {
		super();
		this.buildingNum = buildingNum;
	}

	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}
	
	public String getBuildingNum() {
		return buildingNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "楼层数：" + getBuildingNum() + "\n";
	}
	
	
}
