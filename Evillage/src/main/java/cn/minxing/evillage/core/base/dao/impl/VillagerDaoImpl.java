package cn.minxing.evillage.core.base.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.IVillagerDao;
import cn.minxing.evillage.core.entity.Villager;

/**
 * Implementation class of IVillagerDao interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "villagerDao")
public class VillagerDaoImpl extends GenericDaoImpl<Villager, String> implements
		IVillagerDao {

	public VillagerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
