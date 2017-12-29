package cn.et.数据校验.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.数据校验.entity.UserInfo;

/**
 * 后台验证步骤
 *   1.javaBean添加验证注解
 *   2.action中使用@Valid表示javaBean  使用Errors或BindingResult判断验证是否失败
 * @author Administrator
 *
 */
@Controller
public class RegController {
	//@Valid 自动应用jsr303 并装配  @ModelAttribute("user")修改bean的id
	@RequestMapping(value="/reg", method=RequestMethod.POST)
	public String regUser(@Valid UserInfo user, BindingResult error) throws IOException{
		if(!user.getPassword().equals(user.getRePassword())){ //编程式校验
			error.addError(new FieldError("userInfo", "password", "两次密码不一致"));
		}
		if(error.hasErrors()){
			return "/page/dataVeritfy.jsp";
		}
		return "/page/dataVeritfySuc.jsp";
	}
}
