package cn.minxing.evillage.core.business.service.impl;

import javax.annotation.Resource;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.business.dao.IReservationDao;
import cn.minxing.evillage.core.business.service.IReservationService;
import cn.minxing.evillage.core.entity.Reservation;

/**
 * @author 李彬峰
 *
 */
public class ReservationServiceImpl extends
		GenericServiceImpl<Reservation, String> implements IReservationService {

	@Resource(name = "reservationDao")
	private IReservationDao reservationDao;

	@Override
	public IGenericDao<Reservation, String> getGenericDao() {
		// TODO Auto-generated method stub
		return this.reservationDao;
	}

}
