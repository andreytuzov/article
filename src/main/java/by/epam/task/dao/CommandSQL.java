package by.epam.task.dao;

public class CommandSQL {
	private CommandSQL() {}
	
	public static final String SELECT_BOOK = "SELECT * FROM articles";
	public static final String SELECT_BOOK_BY_ID = "SELECT * FROM articles" 
			+ " WHERE " + ColumnLabel.ARTICLE_ID + " = :" + ColumnLabel.ARTICLE_ID;
	public static final String INSERT_BOOK = 
			"INSERT INTO articles(" + ColumnLabel.ARTICLE_TITLE 
				+ ", " + ColumnLabel.ARTICLE_CONTENT 
				+ ", " + ColumnLabel.ARTICLE_CHANGE_TIME + ")"
			+ " VALUES(:" + ColumnLabel.ARTICLE_TITLE
				+ ", :" + ColumnLabel.ARTICLE_CONTENT
				+ ", :" + ColumnLabel.ARTICLE_CHANGE_TIME + ")";
	public static final String DELETE_BOOK = "SELECT * from articles"
			+ " WHERE " + ColumnLabel.ARTICLE_ID + " = :" + ColumnLabel.ARTICLE_ID;
	public static final String DELETE_LIST_BOOK = "SELECT * FROM articles"
			+ " WHERE " + ColumnLabel.ARTICLE_ID + " IN (:" + ColumnLabel.ARTICLE_ID + ")";
	public static final String UPDATE_BOOK = 
			"UPDATE articles SET " + ColumnLabel.ARTICLE_TITLE + " = :" + ColumnLabel.ARTICLE_TITLE 
				+ ", " + ColumnLabel.ARTICLE_CONTENT + " = :" + ColumnLabel.ARTICLE_CONTENT
				+ ", " + ColumnLabel.ARTICLE_CHANGE_TIME + " = :" + ColumnLabel.ARTICLE_CHANGE_TIME
			+ " WHERE " + ColumnLabel.ARTICLE_ID + " = :" + ColumnLabel.ARTICLE_ID;
}
