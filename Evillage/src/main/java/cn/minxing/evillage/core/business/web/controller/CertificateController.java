package cn.minxing.evillage.core.business.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.minxing.evillage.common.exception.web.ApplicationControllerException;
import cn.minxing.evillage.core.business.service.ICertificateService;
import cn.minxing.evillage.core.entity.Certificate;

/**
 * @author 李彬峰
 *
 */
@RestController
@RequestMapping("/certificate")
public class CertificateController {

	@Resource(name = "certificateService")
	private ICertificateService certificateService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());
	
//	public List<Certificate> findAllCertificate(){
//		logger.debug("[CertificateController.findAllCertificate()] is invoking ...");
//		try{
//			List<Certificate> certificateList = this.certificateService.findAll();
//			return certificateList;
//		}catch(ApplicationControllerException ex){
//			
//		}
//	}

}
