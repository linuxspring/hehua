package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @since 2013-12-29
 * @author lwh
 */

public class DateUtil {
	
	//private static final String pattern = "yyyy-MM-dd HH:mm:ss";
	private static final String pattern = "yyyy-MM-dd";
	
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
