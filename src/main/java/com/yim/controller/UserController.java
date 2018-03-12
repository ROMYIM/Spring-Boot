package com.yim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yim.entity.Building;
import com.yim.entity.User;
import com.yim.service.IBuildingService;
import com.yim.service.IUserService;
import com.yim.util.JsonResult;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBuildingService buildingService;
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
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
	
	@RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
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
	
	@RequestMapping("/addBuilding")
	public ResponseEntity<JsonResult> addBuilding(@ModelAttribute("JsonResult") JsonResult result, Building building) {
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
