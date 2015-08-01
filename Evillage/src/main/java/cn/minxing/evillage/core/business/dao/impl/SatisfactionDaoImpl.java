package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.ISatisfactionDao;
import cn.minxing.evillage.core.entity.Satisfaction;

/**
 * Implementation class of ISatisfactionDao interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "satisfactionDao")
public class SatisfactionDaoImpl extends GenericDaoImpl<Satisfaction, Integer>
		implements ISatisfactionDao {

	public SatisfactionDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
