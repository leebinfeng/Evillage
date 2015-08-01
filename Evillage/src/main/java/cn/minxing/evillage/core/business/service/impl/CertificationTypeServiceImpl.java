package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.ICertificationTypeDao;
import cn.minxing.evillage.core.business.service.ICertificationTypeService;
import cn.minxing.evillage.core.entity.CertificationType;

/**
 * @author 李彬峰
 *
 */
@Service(value = "certificationTypeService")
public class CertificationTypeServiceImpl extends
		GenericServiceImpl<CertificationType, Integer> implements
		ICertificationTypeService {
	@Resource(name = "certificationTypeDao")
	private ICertificationTypeDao certificationTypeDao;

	@Override
	public IGenericDao<CertificationType, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.certificationTypeDao;
	}

}
