package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.ICertificationTemplateDao;
import cn.minxing.evillage.core.entity.CertificationTemplate;

/**
 * Implementation class of ICertificationTemplate interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "certificationTemplateDao")
public class CertificationTemplateDaoImpl extends
		GenericDaoImpl<CertificationTemplate, Integer> implements
		ICertificationTemplateDao {

	public CertificationTemplateDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
