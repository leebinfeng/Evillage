package cn.minxing.evillage.core.base.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.minxing.evillage.common.exception.base.ErrorMessage;
import cn.minxing.evillage.common.exception.service.ApplicationServiceException;
import cn.minxing.evillage.common.exception.service.NoSuchObjectException;
import cn.minxing.evillage.core.base.service.IVillagerService;
import cn.minxing.evillage.core.entity.Villager;

/**
 * @author 李彬峰
 *
 */
@RestController
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

	@RequestMapping(value = "villagers", method = RequestMethod.GET)
	public Object findAllVillager() {
		logger.debug("[VillagerController.findAllVillager()] is invoking ...");
		try {
			List<Villager> list = this.villagerService.findAll();
			System.out.println("找到所有村民信息......");
			return list;
		} catch (ApplicationServiceException ex) {
			if (ex instanceof NoSuchObjectException) {
				ErrorMessage em = new ErrorMessage();
				em.setErrormsg("数据库中不存在记录......");
				List<ErrorMessage> list= new ArrayList<ErrorMessage>();
				list.add(em);
				return list;
			} else {
				ErrorMessage em = new ErrorMessage();
				em.setErrormsg("查找数据库时出错......");
				List<ErrorMessage> list= new ArrayList<ErrorMessage>();
				list.add(em);
				return list;
			}
		}
	}

	@RequestMapping(value = "{identityNumber}", method = RequestMethod.GET)
	public Object findVillagerById(
			@PathVariable("identityNumber") String identityNumber) {
		try {
			System.out.println("找到该村民信息");
			return this.villagerService.get(identityNumber);
		} catch (ApplicationServiceException ex) {
			if (ex instanceof NoSuchObjectException) {
				ErrorMessage em = new ErrorMessage();
				em.setErrormsg("数据库中不存在记录......");
				return em;
			} else {
				ErrorMessage em = new ErrorMessage();
				em.setErrormsg("查找数据库时出错......");
				return em;
			}
		}
	}
}
