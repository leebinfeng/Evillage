package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.ICertificateDao;
import cn.minxing.evillage.core.entity.Certificate;

/**
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "certificateDao")
public class CertificateDaoImpl extends GenericDaoImpl<Certificate, String>
		implements ICertificateDao {

	public CertificateDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
