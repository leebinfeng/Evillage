package cn.minxing.evillage.core.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.dao.IStaffDao;
import cn.minxing.evillage.core.base.service.IStaffService;
import cn.minxing.evillage.core.entity.Staff;

/**
 * @author 李彬峰
 *
 */
@Service(value = "staffService")
public class StaffServiceImpl extends GenericServiceImpl<Staff, String>
		implements IStaffService {
	@Resource(name = "staffDao")
	private IStaffDao staffDao;

	@Override
	public IGenericDao<Staff, String> getGenericDao() {
		// TODO Auto-generated method stub
		return this.staffDao;
	}

}
