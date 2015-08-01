package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.IMedicareAccountDao;
import cn.minxing.evillage.core.business.service.IMedicareAccountService;
import cn.minxing.evillage.core.entity.MedicareAccount;

/**
 * @author 李彬峰
 *
 */
@Service(value = "medicareAccountService")
public class MedicareAccountServiceImpl extends
		GenericServiceImpl<MedicareAccount, String> implements
		IMedicareAccountService {
	@Resource(name = "medicareAccountDao")
	private IMedicareAccountDao medicareAccountDao;

	@Override
	public IGenericDao<MedicareAccount, String> getGenericDao() {
		// TODO Auto-generated method stub
		return this.medicareAccountDao;
	}

}
