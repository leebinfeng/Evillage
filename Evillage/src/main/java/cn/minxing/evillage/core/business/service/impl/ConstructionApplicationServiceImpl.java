package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.IConstructionApplicationDao;
import cn.minxing.evillage.core.business.service.IConstructionApplicationService;
import cn.minxing.evillage.core.entity.ConstructionApplication;

/**
 * @author 李彬峰
 *
 */
@Service(value = "constructionApplicationService")
public class ConstructionApplicationServiceImpl extends
		GenericServiceImpl<ConstructionApplication, Integer> implements
		IConstructionApplicationService {
	@Resource(name = "constructionApplicationDao")
	private IConstructionApplicationDao constructionApplicationDao;

	@Override
	public IGenericDao<ConstructionApplication, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.constructionApplicationDao;
	}

}
