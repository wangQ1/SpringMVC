package cn.et.AJAX.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.AJAX.service.ArticleService;
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
public class ArticleController {
	@Autowired
	private ArticleService as;
	/**
	 * 三种返回json的方式
	 * 第一种:原始的输出json的方式
	 * OutputStream os
	 * os.write(通过第三方json-lib转换的json字符串.getBytes("utf-8"));
	 */
	@RequestMapping(value="/qa", method=RequestMethod.GET)
	public String queryAll(String seekContent, OutputStream os) throws Exception{
		List<Map<String, Object>> selectArticle = as.selectArticle(seekContent);
		JSONArray ja = JSONArray.fromObject(selectArticle);
		String jStr = ja.toString();
		os.write(jStr.getBytes("utf-8"));
		return null;
	}
	/**
	 * 第二种:直接返回字节数组,减少了流的输出动作
	 * 需要添加@ResponseBody注解,说明这是一个响应体
	 * @param seekContent
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/qa1", method=RequestMethod.GET)
	public byte[] queryAll1(String seekContent) throws Exception{
		List<Map<String, Object>> selectArticle = as.selectArticle(seekContent);
		JSONArray ja = JSONArray.fromObject(selectArticle);
		String jStr = ja.toString();
		return jStr.getBytes("utf-8");
	}
	/**
	 * 第三种:直接返回List<Map<String, Object>>对象, springMvc自动转换成json，由jackson实现
	 * 需要添加配置消息转换器
	 * @param seekContent
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/qa2", method=RequestMethod.GET)
	public List<Map<String, Object>> queryAll2(String seekContent) throws Exception{
		List<Map<String, Object>> selectArticle = as.selectArticle(seekContent);
		return selectArticle;
	}
	/**
	 * 添加新文章
	 * @param title 文章标题
	 * @param content 文章内容
	 * @param os
	 * @return
	 */
	@RequestMapping(value="/aa", method=RequestMethod.POST)
	public String addArticle(String title, String content, OutputStream os) throws Exception{
		try {
			as.addArticle(title, content);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 删除文章
	 * @param id 文章id
	 * @param os
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/da/{id}", method=RequestMethod.DELETE)
	public String deleteArticle(@PathVariable String id, OutputStream os) throws Exception{
		try {
			as.deleteArticle(id);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 修改文章
	 * @param id 文章id
	 * @param title 文章标题
	 * @param content 文章内容
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/ua/{id}", method=RequestMethod.PUT)
	public String updateArticle(@PathVariable String id, String title, String content, OutputStream os) throws Exception{
		try {
			as.updateArticle(id, title, content);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
