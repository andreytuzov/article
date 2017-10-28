package by.epam.task.dao.sql;

public class UserSQL {
	private UserSQL() {}
	
	public static final String TABLE_USERS = "users";
	
	public static final int INDEX_USER_ID = 1;
	public static final int INDEX_USER_ID_UPDATE = 8;
	public static final int INDEX_USER_PASSWORD_SELECT = 2;
	
	public static final int INDEX_USER_NICKNAME = 1;
	public static final int INDEX_USER_ROLE_ID = 2;
	public static final int INDEX_USER_NAME = 3;
	public static final int INDEX_USER_LASTNAME = 4;
	public static final int INDEX_USER_PHONE = 5;
	public static final int INDEX_USER_EMAIL = 6;
	public static final int INDEX_USER_DRIVEN_EXPERIENCE = 7;
	public static final int INDEX_USER_PASSWORD = 8;
	
	
	public static final String SELECT_USERS = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_id = ?";
	public static final String SELECT_USER_BY_NICKNAME = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_nickname = ?";
	public static final String SELECT_USER_BY_NICKNAME_AND_PASSWORD = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_nickname = ? AND u_password = ?";
	public static final String INSERT_USER = "INSERT INTO users(u_nickname, u_role_id, u_name, u_lastname, u_phone, u_email, u_driven_experience, u_password) "
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_USER = "UPDATE users" 
			+" SET u_nickname = ?, u_role_id = ?, u_name = ?, u_lastname = ?, u_phone = ?, u_email = ?, u_driven_experience = ?"
			+ " WHERE u_id = ?";
}
