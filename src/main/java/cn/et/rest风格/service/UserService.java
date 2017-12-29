package cn.et.rest风格.service;

import java.util.List;
import java.util.Map;

import cn.et.rest风格.utils.PageTools;

public interface UserService {
	/**
	 * 封装了get方法
	 * @return
	 * @throws Exception
	 */
	public PageTools getTableListPager(String name,int curPage) throws Exception;
	
	public abstract List<Map<String, Object>> queryUsers(String name) throws Exception;

	public abstract void saveUser(String name, String phone, String photoPath) throws Exception;

	public abstract void updateUser(String id, String name, String phone, String photoPath) throws Exception;

	public abstract void deleteUser(String id) throws Exception;

	public Map<String, Object> queryUser(String id);
}
