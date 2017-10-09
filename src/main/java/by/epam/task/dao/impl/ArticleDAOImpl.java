package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.task.dao.ArticleDAO;
import by.epam.task.dao.ColumnLabel;
import by.epam.task.dao.CommandSQL;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DaoException;
import by.epam.task.domain.Article;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public Article findOne(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAll() throws DaoException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Article> articleList = null;
		try {
			connection = pool.take();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(CommandSQL.SELECT_BOOK);
			
			articleList = new ArrayList<>();
			Article article = null;
			
			while (resultSet.next()) {
				article = new Article();
				article.setId(resultSet.getInt(ColumnLabel.ARTICLE_ID));
				article.setTitle(resultSet.getString(ColumnLabel.ARTICLE_TITLE));
				article.setContent(resultSet.getString(ColumnLabel.ARTICLE_CONTENT));
				article.setChangeTime(resultSet.getDate(ColumnLabel.ARTICLE_CHANGE_TIME));
				articleList.add(article);
			}
		} catch (ConnectionPoolException e) {
			throw new DaoException("Error completing method findAll", e);
		} catch (SQLException e) {
			throw new DaoException("Error completing sql code", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return articleList;
	}

	@Override
	public int delete(int id) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<Integer> listID) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveOrUpdate(Article article) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
