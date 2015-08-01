package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.ICertificationTemplateDao;
import cn.minxing.evillage.core.business.service.ICertificationTemplateService;
import cn.minxing.evillage.core.entity.CertificationTemplate;

/**
 * @author 李彬峰
 *
 */
@Service(value = "certificationTemplateService")
public class CertificationTemplateServiceImpl extends
		GenericServiceImpl<CertificationTemplate, Integer> implements
		ICertificationTemplateService {
	@Resource(name = "certificationTemplateDao")
	private ICertificationTemplateDao certificationTemplateDao;

	@Override
	public IGenericDao<CertificationTemplate, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.certificationTemplateDao;
	}

}
