package cn.et.数据校验.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.et.数据校验.entity.UserInfo;

/**
 * springMvc中的Model相关的对象是 用来处理和传输数据的对象
 * @Valid 自动应用jsr303
 * @ModelAttribute 用来重命名参数数据
 * Model、ModelMap、Map 都是用来传递数据到视图（request.setAttribute）建议用Map
 * ModelAndView 绑定数据到视图 ，ModelMap用于传递数据，View用于跳转
 * @SessionAttributes 用于请求重定向(redirect) 可以将参数数据存储在session中，使用时必须手动实例化，使用之后必须清除
 * @author Administrator
 */
//@SessionAttributes
@Controller
public class ModelController {
	@ModelAttribute("user")
	public UserInfo getUser(){
		UserInfo user = new UserInfo();
		return user;
	}

	//@Valid 自动应用jsr303并装配  @ModelAttribute("user")修改bean的id
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value="/case", method=RequestMethod.GET)
		public String regUser(Map map) throws IOException{
			map.put("sex", "girl");
			return "/page/MyJsp.jsp";
		}
		@RequestMapping(value="/case1", method=RequestMethod.GET)
		public ModelAndView regUser() throws IOException{
			ModelAndView mav = new ModelAndView("/page/MyJsp.jsp");
			mav.addObject("sex", "boy");
			return mav;
		}
		@RequestMapping(value="/s1",method=RequestMethod.GET)
		public String session(@ModelAttribute("user") UserInfo user) throws Exception{
			return "redirect:/s2";
		}
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/s2",method=RequestMethod.GET)
		public String session(Map map, HttpServletResponse res, SessionStatus sessionStatus) throws Exception{
			UserInfo user = (UserInfo)map.get("user");
			res.getWriter().println(user.getAge());
			sessionStatus.setComplete();  //清除session中的数据
			return null;
		}
}
