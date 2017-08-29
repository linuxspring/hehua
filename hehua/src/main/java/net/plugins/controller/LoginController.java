package net.plugins.controller;

import net.util.Message;
import net.util.ValidateCode;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;



@Controller
public class LoginController {
	protected static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/checklogin.data" ,method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String login( HttpSession session, HttpServletRequest request){
		
		String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/login.jsp";  
		
		String code = (String) session.getAttribute("validateCode");
		String submitCode = WebUtils.getCleanParam(request, "validateCode");
		if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(code,submitCode.toLowerCase())) {
			
			request.setAttribute("showMsg", "验证码错误！");  
			//return resultPageURL;
		}
		Subject user = SecurityUtils.getSubject();

		String passwd="123456";//getMD5("123456");

		String md5 = new Md5Hash(passwd, null,2).toString();
		System.out.println("md5 = " + md5);
		String username = request.getParameter("username");
		UsernamePasswordToken token = new UsernamePasswordToken(username,passwd);
		//CustomUsernamePasswordToken token = new CustomUsernamePasswordToken("admin",passwd.toCharArray(),true,"127.0.0.1","2e23");

		//UsernamePasswordToken token = new UsernamePasswordToken(currUser.getUser_name(),currUser.getPassword());
		token.setRememberMe(true);
		try {
			user.login(token);

			//resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX +"/validcode.jsp";
			//System.out.println("resultPageURL = " + resultPageURL);

		} catch (UnknownAccountException uae) {
			logger.info("用户名为【" + token.getPrincipal() + "】不存在");
		} catch (IncorrectCredentialsException ice) {
			logger.info("用户名为【 " + token.getPrincipal() + " 】密码错误！");
		} catch (LockedAccountException lae) {
			logger.info("用户名为【" + token.getPrincipal() + " 】的账户锁定，请联系管理员。");
		} catch (DisabledAccountException dax) {
			logger.info("用户名为:【" + token.getHost() + "】用户已经被禁用.");
		} catch (ExcessiveAttemptsException eae) {
			logger.info("用户名为:【" + token.getHost() + "】的用户登录次数过多，有暴力破解的嫌疑.");
		} catch (ExpiredCredentialsException eca) {
			logger.info("用户名为:【" + token.getHost() + "】用户凭证过期.");
		} catch (AuthenticationException ae) {
			logger.info("用户名为:【" + token.getHost() + "】用户验证失败.");
		} catch (Exception e) {
			logger.info("别的异常信息。。。。具体查看继承关系");
		}
		System.out.println("xiao======================================");
		return "{\"success\":\"true\",\"msg\":\"ok\"}";
	}
	public static String getMD5(String str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			System.out.println("aaaaaaaaaaaaaaa:"+str);
			System.out.println("aaaaaaaaaaaaaaa:"+md.digest());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
	}
	
	 @RequestMapping("/login/logoutlogout")
	 public String logout(HttpServletRequest request){  
	         SecurityUtils.getSubject().logout();  
	         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/login.jsp";  
	 } 
	
	@RequestMapping(value = "/checkValidateCode" ,method=RequestMethod.POST)
	@ResponseBody
	public Message checkValidateCode(HttpSession session, HttpServletRequest request){
		
		Message msg = new Message();
		String code = (String) session.getAttribute("validateCode");
		String submitCode = WebUtils.getCleanParam(request, "validateCode");
		if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(code,submitCode.toLowerCase())) {
			msg.error();
			msg.msg("验证码错误！");
		}else{
			msg.success();
		}
		return msg;
	}

	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/validateCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
		String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_NUM_ONLY, 4, null);
		request.getSession().setAttribute("validateCode", verifyCode);
		response.setContentType("image/jpeg");
		BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, null, null);
		ImageIO.write(bim, "JPEG", response.getOutputStream());
	}
}
