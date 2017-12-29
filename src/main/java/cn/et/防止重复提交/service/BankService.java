package cn.et.防止重复提交.service;

public interface BankService {
	public void updateBalance(int id, int money);

	public Integer selectBalance(int id);
}
