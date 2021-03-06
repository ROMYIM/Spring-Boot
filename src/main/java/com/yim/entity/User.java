package com.yim.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户对象user")
public class User {
	@ApiModelProperty(value = "用户id", name = "id", dataType = "String", required = true)
	private String id;
	
	@ApiModelProperty(value = "用户姓名", name = "name", dataType = "String", required = true)
	private String name;
	
	@ApiModelProperty(value = "用户性别", name = "gender", dataType = "String", required = true)
	private String gender;
	
	@ApiModelProperty(value = "用户生日", name = "birthday", dataType = "String", required = true)
	private String birthday;
	
	@ApiModelProperty(value = "用户地址", name = "address", dataType = "String", required = false)
	private String address;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
}
