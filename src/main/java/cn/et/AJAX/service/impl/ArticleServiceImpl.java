package cn.et.AJAX.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.AJAX.dao.ArticleDao;
import cn.et.AJAX.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao ad;
	public List<Map<String, Object>> selectArticle(String seekContent) {
		return ad.selectArticle(seekContent);
	}
	public void deleteArticle(String id) {
		ad.queryArticle(id);
	}
	public void updateArticle(String id, String title, String content) {
		ad.updateArticle(id, title, content);
	}
	public void addArticle(String title, String content) {
		ad.addArticle(title, content);
	}
}
