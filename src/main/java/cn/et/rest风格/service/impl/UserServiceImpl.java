package cn.et.rest风格.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.et.rest风格.service.UserService;
import cn.et.rest风格.utils.PageTools;
@Service
public class UserServiceImpl implements UserService {

	public PageTools getTableListPager(String name, int curPage)
			throws Exception {
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
