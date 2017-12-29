package cn.et.rest风格.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.et.rest风格.service.UserService;
import cn.et.rest风格.utils.PageTools;
/**
 *
 * springMvc中的Model相关的对象是 用来处理和传输数据的对象
 * @Valid 自动应用jsr303
 * @ModelAttribute 用来重命名参数数据
 * Model、ModelMap、Map 都是用来传递数据到视图（request.setAttribute）建议用Map
 * ModelAndView 绑定数据到视图 ，ModelMap用于传递数据，View用于跳转
 * @SessionAttributes 用于请求重定向(redirect) 可以将参数数据存储在session中，使用时必须手动实例化，使用之后必须清除
 * @author Administrator
 *
 * REST是设计风格而不是标准 目的只是让url看起来更简洁实用，是资源状态的一种表达，资源是由URI来指定，
 * 对资源的操作包括获取、创建、修改和删除资源这些操作正好对应HTTP协议提供的GET、POST、PUT和DELETE方法。
 * @RequestMapping 处理请求地址映射
 * 浏览器的提交方式 必须和@RequestMapping指定的资源动作必须一致  否则抛出 405
 * 标准的url为：https://www.baidu.com/link?键=值&键=值..
 * rest风格为：https://www.baidu.com/link/键/键..
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService us;
	@RequestMapping(value="/showUsers", method=RequestMethod.GET)
	public String queryUsers(String name, Integer curPage, Model model) throws Exception{
		if(curPage == null){
			curPage = 1;
		}
		PageTools list = us.getTableListPager(name, curPage);
		//request.setAttribute("","");
		model.addAttribute("list", list);
		return "/page/userList.jsp";
	}
	@RequestMapping(value="/showUser/{id}", method=RequestMethod.GET)
	public String queryUser(@PathVariable String id, Model model) throws Exception{
		Map<String, Object> list = us.queryUser(id);
		//request.setAttribute("","");
		model.addAttribute("list", list);
		return "/page/detailUser.ftl";
	}
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUser(String name, String phone, Model model, MultipartFile imageUrl) throws Exception{
		String fileName = imageUrl.getOriginalFilename();
		String absPath = "E:\\WorkSpace\\MyEclipse 10\\SpringMvcUserManage\\src\\main\\webapp\\images";
		imageUrl.transferTo(new File(absPath + "\\" + fileName));
		us.saveUser(name, phone, fileName);
		return queryUsers(null, 1, model);
	}
	@RequestMapping(value="/updateUser/{id}", method=RequestMethod.POST)
	public String updateUser(@PathVariable String id, String name, String phone, Model model, MultipartFile imageUrl) throws Exception{
		String fileName = imageUrl.getOriginalFilename();
		String absPath = "E:\\WorkSpace\\MyEclipse 10\\SpringMvcUserManage\\src\\main\\webapp\\images";
		imageUrl.transferTo(new File(absPath + "\\" + fileName));
		us.updateUser(id, name, phone, fileName);
		return queryUsers(null, 1, model);
	}
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public String deleteUser(String id, Model model) throws Exception{
		us.deleteUser(id);
		return queryUsers(null, 1, model);
	}
	//实现图片下载
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<byte[]> updateFood(String photoPath) throws Exception{
		   String absPath = "E:\\WorkSpace\\MyEclipse 10\\SpringMvcUserManage\\src\\main\\webapp\\images\\" + photoPath;
	       String fileName = photoPath;
	       //需要下载的目标文件
	       File file = new File(absPath);
	       //设置响应头
	       HttpHeaders hh = new HttpHeaders();
	       //设置下载的文件的名称
	       hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
	       //读取目标文件为二进制数组
	       byte[] fileByte = FileCopyUtils.copyToByteArray(file);
	       //构建ResponseEntity对象
	       ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte, hh, HttpStatus.CREATED);
	       return re;
	}
}
