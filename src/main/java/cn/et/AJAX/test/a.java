package cn.et.AJAX.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * json字符串中的键的格式一定要为："键":值
 * 如果值是数字那么不需要双引号 ， 值为字符串 必须带双引号
 * @author Administrator
 *
 */

public class a {
	
	public static void main(String[] args) {
		parseArray();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void parseObject(){
		Map map = new HashMap();
		map.put("id", 1);
		JSONObject jo = JSONObject.fromObject(map);//解析单个json对象
		System.out.println(jo.toString());
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void parseArray(){
		Map map = new HashMap();
		map.put("id", 1);
		map.put("userName", "A");
		Map map1 = new HashMap();
		map1.put("id", 2);
		map1.put("userName", "B");
		List list = new ArrayList();
		list.add(map);
		list.add(map1);
		JSONArray ja = JSONArray.fromObject(list); //解析json数组
		System.out.println(ja.toString());
	}
}
