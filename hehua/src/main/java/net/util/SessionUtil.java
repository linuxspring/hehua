package net.util;

import net.plugins.model.User;
import org.apache.shiro.SecurityUtils;


/**
 *
 * @since 2013-11-12
 * @author lwh
 */

public class SessionUtil {
	
	public static User getCurrentUser(){
		
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		
		return user;
	}
	
	public static String getUserName(){
		
		return "";//getCurrentUser().getUser_name();
	}
	
	public static long getUserId(){
		
		return  1;//getCurrentUser().getUser_id();
	}

}
