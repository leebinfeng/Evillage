package cn.minxing.evillage.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author libinfeng 将日期字符串转换为yyyy-mm-dd格式
 *
 */
public class FormatDate {

	public Date formatMyDate(String date) {
		DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date formatedDate = sdf.parse(date);
			return formatedDate;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

}
