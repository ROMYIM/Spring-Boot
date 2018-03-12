package com.yim.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yim.util.JsonResult;

@RestControllerAdvice(basePackages = "com.yim.controller")
public class ExceptionHandleController {
	
	@ModelAttribute("JsonResult")
	public JsonResult initJsonResult() {
		return new JsonResult();
	}
}
