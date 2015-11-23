package cn.minxing.evillage.core.forum.service.impl;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.entity.Proposal;
import cn.minxing.evillage.core.forum.dao.IProposalDao;
import cn.minxing.evillage.core.forum.service.IProposalService;

/**
 * @author 李彬峰
 *
 */
public class ProposalServiceImpl extends GenericServiceImpl<Proposal, Integer>
		implements IProposalService {

	private IProposalDao proposalDao;

	@Override
	public IGenericDao<Proposal, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.proposalDao;
	}

}
