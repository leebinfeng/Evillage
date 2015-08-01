package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.ICertificationDao;
import cn.minxing.evillage.core.business.service.ICertificationService;
import cn.minxing.evillage.core.entity.Certification;

/**
 * @author 李彬峰
 *
 */
@Service(value = "certificationService")
public class CertificationServiceImpl extends
		GenericServiceImpl<Certification, String> implements
		ICertificationService {
	@Resource(name = "certificationDao")
	private ICertificationDao certificationDao;

	@Override
	public IGenericDao<Certification, String> getGenericDao() {
		// TODO Auto-generated method stub
		return this.certificationDao;
	}

}
