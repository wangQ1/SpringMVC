package cn.et.防止重复提交.dao;

public interface BankDao {
	public void updateBalance(int id, int money);

	public Integer selectBalance(int id);
}
