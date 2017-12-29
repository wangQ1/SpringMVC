package cn.et.防止重复提交.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.et.防止重复提交.dao.BankDao;
import cn.et.防止重复提交.service.BankService;
@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDao bd;
	public void updateBalance(int id, int money) {
		bd.updateBalance(id, money);
	}
	public Integer selectBalance(int id){
		return bd.selectBalance(id);
	}
}
