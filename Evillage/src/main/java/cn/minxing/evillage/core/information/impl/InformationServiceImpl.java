package cn.minxing.evillage.core.information.impl;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.entity.Information;
import cn.minxing.evillage.core.information.dao.IInformationDao;
import cn.minxing.evillage.core.information.service.IInformationService;

/**
 * @author 李彬峰
 *
 */
public class InformationServiceImpl extends
		GenericServiceImpl<Information, Integer> implements IInformationService {

	private IInformationDao informationDao;

	@Override
	public IGenericDao<Information, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.informationDao;
	}

}
