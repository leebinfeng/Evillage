package cn.minxing.evillage.core.base.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.minxing.evillage.common.exception.service.ApplicationServiceException;
import cn.minxing.evillage.common.exception.service.NoSuchObjectException;
import cn.minxing.evillage.core.base.service.IVillagerService;
import cn.minxing.evillage.core.entity.Villager;

@Controller
@RequestMapping("/villager/*")
public class VillagerController {

	@Resource(name = "villagerService")
	private IVillagerService villagerService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());

	public boolean validateUserIsExist(String villagerId) {
		logger.debug("[VillagerController.validateUserIsExist(String villagerId)] is invoking ...");
		return false;
	}

	public void createVillager() {

	}

	@RequestMapping(value = "findAllVillager", method = RequestMethod.GET)
	@ResponseBody
	public Object findAllVillager() {
		logger.debug("[VillagerController.findAllVillager()] is invoking ...");
		try {
			List<Villager> list = this.villagerService.findAll();
			System.out.println("找到所有村民信息......");
			return list;
		} catch (ApplicationServiceException ex) {
			if (ex instanceof NoSuchObjectException) {
				ex.printStackTrace();
				return "数据库中不存在记录......";
			} else {
				return "查找数据库时出现错误......";
			}
		}	

	}
}
