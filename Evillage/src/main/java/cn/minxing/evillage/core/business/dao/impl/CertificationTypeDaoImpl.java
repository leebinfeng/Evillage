package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.ICertificationTypeDao;
import cn.minxing.evillage.core.entity.CertificationType;

/**
 * Implementation class of ICertificationType interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "certificationTypeDao")
public class CertificationTypeDaoImpl extends
		GenericDaoImpl<CertificationType, Integer> implements
		ICertificationTypeDao {

	public CertificationTypeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
