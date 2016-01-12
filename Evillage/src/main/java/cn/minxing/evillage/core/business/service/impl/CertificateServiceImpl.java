package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.ICertificateDao;
import cn.minxing.evillage.core.business.service.ICertificateService;
import cn.minxing.evillage.core.entity.Certificate;

/**
 * @author 李彬峰
 *
 */
@Service(value = "certificateService")
public class CertificateServiceImpl extends
		GenericServiceImpl<Certificate, String> implements ICertificateService {
	@Resource(name = "certificateDao")
	private ICertificateDao certificateDao;

	@Override
	public IGenericDao<Certificate, String> getGenericDao() {
		// TODO Auto-generated method stub
		return this.certificateDao;
	}

}
