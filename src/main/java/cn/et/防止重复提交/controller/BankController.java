package cn.et.防止重复提交.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.防止重复提交.service.BankService;
/**
 * springMvc中的Model相关的对象是 用来处理和传输数据的对象
 * @Valid 自动应用jsr303
 * @ModelAttribute 用来重命名参数数据
 * Model、ModelMap、Map 都是用来传递数据到视图（request.setAttribute）建议用Map
 * ModelAndView 绑定数据到视图 ，ModelMap用于传递数据，View用于跳转
 * @SessionAttributes 用于请求重定向(redirect) 可以将参数数据存储在session中，使用时必须手动实例化，使用之后必须清除
 * @author Administrator
 */
@Controller
public class BankController {
	@Autowired
	private BankService bs;
	@RequestMapping(value="/updateBalance", method=RequestMethod.GET)
	public String updateBalance(Integer money, OutputStream os) throws IOException{
		bs.updateBalance(1, money);
		os.write(("余额为：" + bs.selectBalance(1)).getBytes("utf-8"));
		return null;
	}
}
