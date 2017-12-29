package cn.et.AJAX.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.AJAX.dao.ArticleDao;
@Repository
public class ArticleDaoImpl implements ArticleDao{
	@Autowired
	JdbcTemplate jt;
	public  List<Map<String, Object>> selectArticle(String seekContent) {
		String sql = "select * from article where a_content like '%"+seekContent+"%'";
		return jt.queryForList(sql);
	}
	public void queryArticle(String id) {
		String sql = "delete from article where a_id = " + id;
		jt.execute(sql);
	}
	public void updateArticle(String id, String title, String content) {
		String sql = "update article set a_title = '"+title+"', a_content = '"+content+"' where a_id = " + id;
		jt.execute(sql);
	}
	public void addArticle(String title, String content) {
		String sql = "insert into article(a_title, a_content) values('"+title+"', '"+content+"')";
		jt.execute(sql);
	}
}