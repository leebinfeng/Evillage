package cn.minxing.evillage.core.forum.service.impl;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.entity.Report;
import cn.minxing.evillage.core.forum.dao.IReportDao;
import cn.minxing.evillage.core.forum.service.IReportService;

/**
 * @author 李彬峰
 *
 */
public class ReportServiceImpl extends GenericServiceImpl<Report, Integer>
		implements IReportService {

	private IReportDao reportDao;

	@Override
	public IGenericDao<Report, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.reportDao;
	}

}
