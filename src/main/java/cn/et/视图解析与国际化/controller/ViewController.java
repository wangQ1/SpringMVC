package cn.et.视图解析与国际化.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.数据校验.entity.UserInfo;
/**
 * springMvc中的Model相关的对象是 用来处理和传输数据的对象
 * @Valid 自动应用jsr303
 * @ModelAttribute 用来重命名参数数据
 * Model、ModelMap、Map 都是用来传递数据到视图（request.setAttribute）建议用Map
 * ModelAndView 绑定数据到视图 ，ModelMap用于传递数据，View用于跳转
 * @SessionAttributes 用于请求重定向(redirect) 可以将参数数据存储在session中，使用时必须手动实例化，使用之后必须清除
 * @author Administrator
 *
 * 后台验证步骤
 *   1.javaBean添加验证注解
 *   2.action中使用@Valid表示javaBean  使用Errors或BindingResult判断验证是否失败
 * @author Administrator
 *
 */
@Controller
public class ViewController {
	//@Valid 自动应用jsr303并装配  @ModelAttribute("user")修改bean的id
	@RequestMapping(value="/viewAnalysis", method=RequestMethod.GET)
	public String regUser() throws IOException{
		return "page/result";
	}
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation", method=RequestMethod.POST)
	public String regUser(OutputStream os, Locale locale) throws IOException{
		os.write(ms.getMessage("key", null, locale).getBytes("UTF-8"));//将信息文件与浏览器的语言关联
		return null;
	}
	@RequestMapping(value="/mid", method=RequestMethod.GET)
	public String mid() throws IOException{
		return "page/result";
	}
	
	@RequestMapping(value="/myreg", method=RequestMethod.POST)
	public String mid(@ModelAttribute("userInfo") @Valid UserInfo userInfo, BindingResult error) throws IOException{
		if(error.hasErrors()){
			return "page/result";
		}
		return null;
	}
}
