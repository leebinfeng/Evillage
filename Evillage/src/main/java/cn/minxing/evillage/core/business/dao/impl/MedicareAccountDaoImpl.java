package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.IMedicareAccountDao;
import cn.minxing.evillage.core.entity.MedicareAccount;

/**
 * Implementation class of IMedicareAccountDao interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "medicareAccountDao")
public class MedicareAccountDaoImpl extends
		GenericDaoImpl<MedicareAccount, String> implements IMedicareAccountDao {

	public MedicareAccountDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
