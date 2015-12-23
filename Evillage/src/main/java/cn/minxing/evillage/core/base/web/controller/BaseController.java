package cn.minxing.evillage.core.base.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.minxing.evillage.core.base.service.IVillagerService;

@Controller
public class BaseController {
	@Resource(name = "villagerService")
	IVillagerService villagerService;

	@RequestMapping({ "/", "/login" })
	public String login() {
		return "common/login";
	}

	@RequestMapping({ "/index" })
	public String index() {
		return "home";
	}

}
