package by.epam.task.dao;

/**
 * Класс, содержащий названия полей всех таблиц из базы данных
 */
public class ColumnLabel {

	private ColumnLabel() {}
	
	// Поля таблицы cars
	/** Первичный ключ */
	public static final String CAR_ID = "c_id";                                
	/** Модель автомобиля */
	public static final String CAR_MODEL = "c_model";                          
	/** Объем двигателя автомобиля */
	public static final String CAR_VOLUME = "c_volume";                        
	/** Мощность двигателя автомобиля */
	public static final String CAR_POWER = "c_power";                          
	/** Год выпуска */
	public static final String CAR_YEAR = "c_year";                            
	/** Цена проката за час */
	public static final String CAR_PRISE = "c_prise";                          
	/** Описание автомобиля */
	public static final String CAR_DESCRIPTION = "c_description";              

	// Поля таблицы users
	/** Первичный ключ */
	public static final String USER_ID = "u_id";                               
	/** Ник пользователя */
	public static final String USER_NICKNAME = "u_nickname";                   
	/** Пароль пользователя */
	public static final String USER_PASSWORD = "u_password";                   
	 /** Внешний ключ на таблицу ролей */
	public static final String USER_ROLE_ID = "u_role_id";                    
	/** Имя пользователя */
	public static final String USER_NAME = "u_name";                           
	/** Фамилия пользователя */
	public static final String USER_LASTNAME = "u_lastname";                   
	/** Телефон пользователя */
	public static final String USER_PHONE = "u_phone";                         
	/** Электронная почта пользователя */
	public static final String USER_EMAIL = "u_email";                         
	/** Опыт вождения пользователя */
	public static final String USER_DRIVEN_EXPERIENCE = "u_driven_experience"; 
	
	// Поля таблицы roles
	/** Первичный ключ */
	public static final String ROLE_ID = "r_id";                               
	/** Название роли */
	public static final String ROLE_NAME = "r_name";                           
	
	// Поля таблицы deals
	/** Первичный ключ */
	public static final String DEAL_ID = "d_id";                               
	/** Внешний ключ на таблицу пользователей */
	public static final String DEAL_USER_ID = "d_user_id";                     
	/** Внешний ключ на таблицу автомобилей */
	public static final String DEAL_CAR_ID = "d_car_id";                       
	/** Внешний ключ на таблицу состояний заказов */
	public static final String DEAL_DEAL_STATE_ID = "d_deal_state_id";         
	/** Стоимость проката */
	public static final String DEAL_COST = "d_cost";                           
	/** Дата начала проката */
	public static final String DEAL_DATE_FROM = "d_date_from";                 
	/** Дата окончания проката */
	public static final String DEAL_DATE_TO = "d_date_to";                     
	/** Комментарий пользователя */
	public static final String DEAL_COMMENT = "d_comment";                     
	/** Причина отмены заказа */
	public static final String DEAL_CANCEL_REASON = "d_cancel_reason";         
	/** Номер пасспорта */
	public static final String DEAL_PASSPORT_NUMBER = "d_passport_number";     
	
	// Поля таблицы damages
	/** Внешний ключ на таблицу заказов */
	public static final String DAMAGE_ID = "dmg_deal_id";                      
	/** Стоимость ремонта автомобиля */
	public static final String DAMAGE_COST = "dmg_cost";                       
	/** Причина повреждения автомобиля */
	public static final String DAMAGE_DESCRIPTION = "dmg_description";         
	
	// Поля таблицы deal_states
	/** Первичный ключ */
	public static final String DEAL_STATE_ID = "ds_id";                        
	/** Название состояния*/
	public static final String DEAL_STATE_NAME = "ds_name";                    
}
