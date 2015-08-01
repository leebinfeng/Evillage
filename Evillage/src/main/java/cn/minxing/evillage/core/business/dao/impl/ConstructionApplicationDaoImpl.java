package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.IConstructionApplicationDao;
import cn.minxing.evillage.core.entity.ConstructionApplication;

/**
 * Implementation class of IConstructionApplicationDao interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "constructionApplicationDao")
public class ConstructionApplicationDaoImpl extends
		GenericDaoImpl<ConstructionApplication, Integer> implements
		IConstructionApplicationDao {

	public ConstructionApplicationDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
