package cn.minxing.evillage.core.base.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.IStaffDao;
import cn.minxing.evillage.core.entity.Staff;

/**
 * Implementation class of IStaffDao interface
 * 
 * @author 李彬峰
 *
 */
@Repository(value = "staffDao")
public class StaffDaoImpl extends GenericDaoImpl<Staff, String> implements
		IStaffDao {

	public StaffDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
