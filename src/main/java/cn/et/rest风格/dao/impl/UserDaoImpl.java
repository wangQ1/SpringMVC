package cn.et.rest风格.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.et.rest风格.dao.UserDao;
@Repository
public class UserDaoImpl implements UserDao {

	public Integer getUserCount(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> paging(String name, int startIndex,
			int length) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> queryUsers(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(String name, String phone, String photoPath)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void updateUser(String id, String name, String phone,
			String photoPath) throws Exception {
		// TODO Auto-generated method stub

	}

	public void deleteUser(String id) throws Exception {
		// TODO Auto-generated method stub

	}

	public Map<String, Object> queryUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
