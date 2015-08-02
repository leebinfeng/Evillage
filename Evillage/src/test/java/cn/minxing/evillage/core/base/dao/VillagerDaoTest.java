package cn.minxing.evillage.core.base.dao;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.minxing.evillage.core.entity.Villager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:cn/minxing/evillage/config/applicationContext-*.xml")
@Transactional
public class VillagerDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	private final Logger logger = LoggerFactory
			.getLogger(VillagerDaoTest.class);

	@Resource(name = "villagerDao")
	private IVillagerDao villagerDao;

	@Test
	@Rollback(false)
	public void testSave() {
		Villager villager = new Villager();
		villager.setIdentityNumber("441421199108144012");
		villager.setFullName("李彬峰");
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 7, 14);
		Date birthday = cal.getTime();
		villager.setBirthday(birthday);
		villager.setEthnicity("汉族");
		villager.setGender("男");
		villager.setHomeAddress("minxingcun");
		villager.setInMigrant("是");
		villager.setJob("学生");
		villager.setLandlines("12345678");
		villager.setMobiles("13416197836");
		villager.setNativePlace("梅州");
		villager.setWorkAddress("华南农业大学");
		villagerDao.save(villager);
		logger.info("------插入村民-----");
	}

}
