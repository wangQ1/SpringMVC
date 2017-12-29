package cn.et.rest风格.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	/**
	 * 封装了get方法
	 * @return
	 * @throws Exception
	 */
	public Integer getUserCount(String name) throws Exception;
	
	public List<Map<String, Object>> paging(String name, int startIndex, int length) throws Exception;
	
	public abstract List<Map<String, Object>> queryUsers(String name) throws Exception;

	public abstract void saveUser(String name, String phone, String photoPath) throws Exception;

	public abstract void updateUser(String id, String name, String phone, String photoPath) throws Exception;

	public abstract void deleteUser(String id) throws Exception;

	public Map<String, Object> queryUser(String id);
}
