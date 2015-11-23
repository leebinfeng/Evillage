package cn.minxing.evillage.core.information.impl;

import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.impl.GenericServiceImpl;
import cn.minxing.evillage.core.entity.Message;
import cn.minxing.evillage.core.information.dao.IMessageDao;
import cn.minxing.evillage.core.information.service.IMessageService;

/**
 * @author 李彬峰
 *
 */
public class MessageServiceImpl extends GenericServiceImpl<Message, Integer>
		implements IMessageService {

	private IMessageDao messageDao;

	@Override
	public IGenericDao<Message, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return this.messageDao;
	}

}
