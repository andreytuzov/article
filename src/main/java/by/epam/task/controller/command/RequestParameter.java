package by.epam.task.controller.command;

/**
 * Класс с именами параметров заросов  
 */
public class RequestParameter {
	
	private RequestParameter() { }
	
	// Поля таблицы cars
	/** Первичный ключ */
	public static final String CAR_ID = "rc_id";                                
	/** Модель автомобиля */
	public static final String CAR_MODEL = "rc_model";                          
	/** Объем двигателя автомобиля */
	public static final String CAR_VOLUME = "rc_volume";                        
	/** Мощность двигателя автомобиля */
	public static final String CAR_POWER = "rc_power";                          
	/** Год выпуска */
	public static final String CAR_YEAR = "rc_year";                            
	/** Цена проката за час */
	public static final String CAR_PRISE = "rc_prise";                          
	/** Описание автомобиля */
	public static final String CAR_DESCRIPTION = "rc_description";
	/** Список автомобилей */
	public static final String CAR_LIST = "rc_list";
	/** Объект автомобиль */
	public static final String CAR_OBJECT = "rc_object";

	// Поля таблицы users
	/** Ник пользователя */
	public static final String USER_NICKNAME = "ru_nickname";                   
	/** Пароль пользователя */
	public static final String USER_PASSWORD = "ru_password";                   
	/** Имя пользователя */
	public static final String USER_NAME = "ru_name";                           
	/** Фамилия пользователя */
	public static final String USER_LASTNAME = "ru_lastname";                   
	/** Телефон пользователя */
	public static final String USER_PHONE = "ru_phone";                         
	/** Электронная почта пользователя */
	public static final String USER_EMAIL = "ru_email";                         
	/** Опыт вождения пользователя */
	public static final String USER_DRIVEN_EXPERIENCE = "ru_driven_experience"; 
	/** Объект пользователя */
	public static final String USER_OBJECT = "ru_object";
	/** Список пользователей */
	public static final String USER_LIST = "ru_list";
		
	// Поля таблицы deals
	/** Первичный ключ */
	public static final String DEAL_ID = "rd_id";                               
	/** Внешний ключ на таблицу пользователей */
	public static final String DEAL_USER_ID = "rd_user_id";                     
	/** Внешний ключ на таблицу автомобилей */
	public static final String DEAL_CAR_ID = "rd_car_id";                       
	/** Внешний ключ на таблицу состояний заказов */
	public static final String DEAL_DEAL_STATE_ID = "rd_deal_state_id";         
	/** Стоимость проката */
	public static final String DEAL_COST = "rd_cost";                           
	/** Дата начала проката */
	public static final String DEAL_DATE_FROM = "rd_date_from";                 
	/** Дата окончания проката */
	public static final String DEAL_DATE_TO = "rd_date_to";                     
	/** Комментарий пользователя */
	public static final String DEAL_COMMENT = "rd_comment";                     
	/** Причина отмены заказа */
	public static final String DEAL_CANCEL_REASON = "rd_cancel_reason";         
	/** Номер пасспорта */
	public static final String DEAL_PASSPORT_NUMBER = "rd_passport_number"; 
	/** Список заказов */
	public static final String DEAL_LIST = "rd_list";
	/** Объект заказа */
	public static final String DEAL_OBJECT = "rd_object";
	/** Список заказов с занятыми датами для данного автомобиля */
	public static final String DEAL_LIST_CAR_SCHEDULE = "rd_list_car_schedule";
	
	// Поля таблицы damages
	/** Внешний ключ на таблицу заказов */
	public static final String DAMAGE_ID = "rdmg_deal_id";                      
	/** Стоимость ремонта автомобиля */
	public static final String DAMAGE_COST = "rdmg_cost";                       
	/** Причина повреждения автомобиля */
	public static final String DAMAGE_DESCRIPTION = "rdmg_description";         
	
	// Поля таблицы deal_states
	/** Первичный ключ */
	public static final String DEAL_STATE_NAME = "rds_name";	
	
	public static final String ACTION = "action";
}
