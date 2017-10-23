package by.epam.task.dao.sql;

public class UserSQL {
	private UserSQL() {}
	
	public static final String TABLE_USERS = "users";
	
	public static final int INDEX_USER_NICKNAME = 1;
	public static final int INDEX_USER_PASSWORD = 2;
	public static final int INDEX_USER_ROLE_ID = 3;
	public static final int INDEX_USER_NAME = 4;
	public static final int INDEX_USER_LASTNAME = 5;
	public static final int INDEX_USER_PHONE = 6;
	public static final int INDEX_USER_EMAIL = 7;
	public static final int INDEX_USER_DRIVEN_EXPERIENCE = 8;
	public static final int INDEX_USER_ID = 9;
	
	public static final String SELECT_USERS = "SELECT * FROM users";
	public static final String SELECT_USER_BY_NICKNAME_AND_PASSWORD = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_nickname = ? AND u_password = ?";
	public static final String INSERT_USER = "INSERT INTO users(u_nickname, u_password, u_role_id, u_name, u_lastname, u_phone, u_email, u_driven_experience) "
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_USER = "UPDATE users" 
			+" SET u_nickname = ?, u_password = ?, u_role_id = ?, u_name = ?, u_lastname = ?, u_phone = ?, u_email = ?, u_driven_experience = ?"
			+ " WHERE u_id = ?";
}