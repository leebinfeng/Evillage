package cn.minxing.evillage.core.business.dao.impl;

import org.springframework.stereotype.Repository;

import cn.minxing.evillage.core.base.dao.impl.GenericDaoImpl;
import cn.minxing.evillage.core.business.dao.IReservationDao;
import cn.minxing.evillage.core.entity.Reservation;

/**
 * @author 李彬峰
 *
 */
@Repository(value = "ReservationDao")
public class ReservationDaoImpl extends GenericDaoImpl<Reservation, String>
		implements IReservationDao {

}
