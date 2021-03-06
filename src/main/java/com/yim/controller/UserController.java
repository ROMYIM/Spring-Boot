package com.yim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yim.entity.Building;
import com.yim.entity.User;
import com.yim.service.IBuildingService;
import com.yim.service.IUserService;
import com.yim.util.JsonResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBuildingService buildingService;
	
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@ModelAttribute("building")
	public Building initBuilding(String buildingNum) {
		return new Building(buildingNum);
	}
	
	@ApiOperation(value = "登录操作", notes = "根据用户id进行登录")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", dataType = "String")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> login(@ModelAttribute("JsonResult") JsonResult result, String id) {
		User user = userService.getUserById(id);
		if (user != null) {
			result.setCode("ok");
			result.setResult("login success");
		} else {
			result.setCode("error");
			result.setResult("login failed");
		}
		return new ResponseEntity<JsonResult>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "注册操作", notes = "注册用户信息")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> register(@ModelAttribute("JsonResult") JsonResult result, User user) {
		int count = userService.addUser(user);
		if (count ==1) {
			result.setCode("ok");
			result.setResult("register success");
		} else {
			result.setCode("error");
			result.setResult("register failed");
		}
		return new ResponseEntity<JsonResult>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "添加楼宇", notes = "根据Building对象添加楼宇， 只有一个buildingNum属性")
	@RequestMapping(value = "/addBuilding", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> addBuilding(@ModelAttribute("JsonResult") JsonResult result, 
			@ModelAttribute("building") Building building) {
		int count = buildingService.addBuilding(building);
		if (count > 0) {
			result.setCode("ok");
			result.setResult("add building success");
		} else {
			result.setCode("error");
			result.setResult("failed");
		}
		return new ResponseEntity<JsonResult>(result, HttpStatus.OK);
	}
}
