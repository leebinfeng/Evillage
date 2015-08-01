package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.ICertificationDao;
import cn.minxing.evillage.core.entity.Certification;

/**
 * Implementation class of ICertificationDao interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "certificationDao")
public class CertificationDaoImpl extends GenericDaoImpl<Certification, String>
		implements ICertificationDao {

	public CertificationDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
