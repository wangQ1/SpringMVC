package cn.et.防止重复提交;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		String myToken = request.getParameter("myToken");
		Object SessToken = request.getSession().getAttribute("myToken");
		//验证是否为重复提交
		if(myToken != null){
			if(SessToken == null){
				return false;
			}else{
				if(myToken.equals(SessToken)){
					request.getSession().removeAttribute("myToken");
					return true;
				}else{
					return false;
				}
			}
		}else{
			return false;
		}
	}

}
