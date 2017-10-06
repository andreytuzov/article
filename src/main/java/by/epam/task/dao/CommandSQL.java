package by.epam.task.dao;

public class CommandSQL {
	private CommandSQL() {}
	
	public static final String SELECT_BOOK = "SELECT * FROM articles";
	public static final String SELECT_BOOK_BY_ID = "SELECT * FROM articles" 
			+ " WHERE id = :" + ColumnLabel.ARTICLE_ID;
	public static final String INSERT_BOOK = "INSERT INTO articles(title, content, change_time)"
			+ " VALUES(:" + ColumnLabel.ARTICLE_TITLE
			+ ", :" + ColumnLabel.ARTICLE_CONTENT
			+ ", :" + ColumnLabel.ARTICLE_CHANGE_TIME + ")";
	public static final String DELETE_BOOK = "SELECT * from articles"
			+ " WHERE id = :" + ColumnLabel.ARTICLE_ID;
	public static final String DELETE_LIST_BOOK = "SELECT * from articles"
			+ " WHERE id IN (:" + ColumnLabel.ARTICLE_ID + ")";
	public static final String UPDATE_BOOK = "UPDATE articles"
			+ " SET title = :" + ColumnLabel.ARTICLE_TITLE 
			+ ", content = :" + ColumnLabel.ARTICLE_CONTENT
			+ ", change_time = :" + ColumnLabel.ARTICLE_CHANGE_TIME
			+ " WHERE id = :" + ColumnLabel.ARTICLE_ID;
}
