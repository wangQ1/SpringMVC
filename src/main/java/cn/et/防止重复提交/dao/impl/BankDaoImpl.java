package cn.et.防止重复提交.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cn.et.防止重复提交.dao.BankDao;
@Repository
public class BankDaoImpl implements BankDao{
	@Autowired
	JdbcTemplate jt;
	public void updateBalance(int id, int money){
		String sql = "update bank set balance = balance - "+money+" where id = " +id;
		jt.execute(sql);
	}
	public Integer selectBalance(int id) {
		String sql = "select balance from bank where id = " +id;
		return jt.queryForObject(sql, Integer.class);
	}
}