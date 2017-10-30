package by.epam.task.dao.sql;

/**
 * Класс с sql-запросами для таблицы users
 */
public class UserSQL {
	private UserSQL() {}	
	
	/** Номер параметра: первичный ключ */
	public static final int INDEX_USER_ID = 1;
	/** Номер параметра: первичный ключ для запроса по обновлению записи */
	public static final int INDEX_USER_ID_UPDATE = 8;
	/** Номер параметра: пароль пользователя для запроса выборки */
	public static final int INDEX_USER_PASSWORD_SELECT = 2;
	
	/** Номер параметра: ник пользователя */
	public static final int INDEX_USER_NICKNAME = 1;
	/** Номер параметра: внешния ключ на таблицу ролей (roles)*/
	public static final int INDEX_USER_ROLE_ID = 2;
	/** Номер параметра: имя пользователя */
	public static final int INDEX_USER_NAME = 3;
	/** Номер параметра: фамилия пользователя */
	public static final int INDEX_USER_LASTNAME = 4;
	/** Номер параметра: телефон пользователя */
	public static final int INDEX_USER_PHONE = 5;
	/** Номер параметра: электронная почта пользователя */
	public static final int INDEX_USER_EMAIL = 6;
	/** Номер параметра: опыт вождения пользователя */
	public static final int INDEX_USER_DRIVEN_EXPERIENCE = 7;
	/** Номер параметра: пароль пользователя */
	public static final int INDEX_USER_PASSWORD = 8;
	
	/** SQL-запрос для получения всех записей из таблицы */
	public static final String SELECT_USERS = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id";
	/** SQL-запрос для получения записи из таблицы по указанному первичному ключу */
	public static final String SELECT_USER_BY_ID = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_id = ?";
	/** SQL-запрос для получения записи из таблицы по указанному нику пользователя */
	public static final String SELECT_USER_BY_NICKNAME = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_nickname = ?";
	/** SQL-запрос для получения записи из таблицы по указанному нику и паролю пользователя */
	public static final String SELECT_USER_BY_NICKNAME_AND_PASSWORD = "SELECT * FROM users u, roles r WHERE u.u_role_id = r.r_id AND u_nickname = ? AND u_password = ?";
	/** SQL-запрос для вставки записи в таблицу */
	public static final String INSERT_USER = "INSERT INTO users(u_nickname, u_role_id, u_name, u_lastname, u_phone, u_email, u_driven_experience, u_password) "
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	/** SQL-запрос для обновления записи в таблице */
	public static final String UPDATE_USER = "UPDATE users" 
			+" SET u_nickname = ?, u_role_id = ?, u_name = ?, u_lastname = ?, u_phone = ?, u_email = ?, u_driven_experience = ?"
			+ " WHERE u_id = ?";
}
