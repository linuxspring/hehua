package interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @since 2013-11-26
 * @author lwh
 */

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if (request.getSession().getAttribute("validateCode") == null) {
			
			// 如果是ajax请求响应头会有，x-requested-with；
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				
				response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
				return false;
			}

		}
		return true;
	}

}
