package cn.et.AJAX.dao;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
	public  List<Map<String, Object>> selectArticle(String seekContent);

	public void queryArticle(String id);

	public void updateArticle(String id, String title, String content);

	public void addArticle(String title, String content);
}
