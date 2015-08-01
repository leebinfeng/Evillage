package cn.minxing.evillage.core.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.dao.IVillagerDao;
import cn.minxing.evillage.core.base.service.IVillagerService;
import cn.minxing.evillage.core.entity.Villager;

/**
 * @author 李彬峰
 *
 */
@Service(value = "villagerService")
public class VillagerServiceImpl extends GenericServiceImpl<Villager, String>
		implements IVillagerService {
	@Resource(name = "villagerDao")
	private IVillagerDao villagerDao;

	@Override
	public IGenericDao<Villager, String> getGenericDao() {
		// TODO Auto-generated method stub
		return this.villagerDao;
	}

}
