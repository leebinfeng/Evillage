package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.ISatisfactionDao;
import cn.minxing.evillage.core.business.service.ISatisfactionService;
import cn.minxing.evillage.core.entity.Satisfaction;

/**
 * @author 李彬峰
 *
 */
@Service(value = "satisfactionService")
public class SatisfactionServiceImpl extends
		GenericServiceImpl<Satisfaction, Integer> implements
		ISatisfactionService {
	@Resource(name = "satisfactionDao")
	private ISatisfactionDao satisfactionDao;

	@Override
	public IGenericDao<Satisfaction, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.satisfactionDao;
	}

}
