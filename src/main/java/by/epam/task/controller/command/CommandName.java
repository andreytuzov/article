package by.epam.task.controller.command;

import by.epam.task.domain.Role;

/**
 * Перечисление все действий доступных на сайте
 */
public enum CommandName {
	
	/** Обработка некорректных запросов */
	WRONG_REQUEST,                                    

	/** Отображение списка автомобилей */
	VIEW_CAR_LIST,                                    
	/** Отображение автомобиля */
	VIEW_CAR,                                         
	/** Отображение страницы для изменения автомобиля */
	VIEW_MODIFY_CAR(Role.ADMIN),                      
	/** Обработка запроса изменения автомобиля */
	MODIFY_CAR(Role.ADMIN),	                          
	/** Обработка запроса удаления автомобиля */
	DELETE_CAR(Role.ADMIN),	                          

	/** Обработка запроса регистрации пользователя */
	SIGN_UP(Role.ANONYMOUS),                          
	/** Обработка запроса входа пользователя */
	LOG_IN(Role.ANONYMOUS),                           
	/** Обработка запроса выхода пользователя */
	LOG_OUT(Role.CUSTOMER, Role.ADMIN),               
	/** Обработка запроса редактирования пользователя */
	MODIFY_USER(Role.CUSTOMER, Role.ADMIN),           
	
	/** Отображение страницы пользователя */
	VIEW_MODIFY_USER_ROOM(Role.CUSTOMER, Role.ADMIN), 
	/** Отображение списка пользователей */
	VIEW_USER_LIST(Role.ADMIN),                       
	
	/** Отображение списка сделок */
	VIEW_DEAL_LIST(Role.ADMIN),                       
	/** Отображение страницы редактирования сделки */
	VIEW_MODIFY_DEAL(Role.ADMIN, Role.CUSTOMER),      
	
	/** Обработка запроса редактирования заказа*/
	MODIFY_DEAL(Role.CUSTOMER),                       
	/** Обработка запроса удаления заказа */
	DELETE_DEAL(Role.CUSTOMER),                       
	/** Обработка запроса подтверждения заказа */
	CONFIRM_DEAL(Role.ADMIN),                         
	/** Обработка запроса отмены заказа */
	CANCEL_DEAL(Role.ADMIN),                          
	/** Обработка запроса оплаты заказа */
	PAY_DEAL(Role.CUSTOMER),                          
	/** Обработка запроса завершения сделки */
	COMPLETE_DEAL(Role.ADMIN),                        
	/** Обработка запроса добавления повреждения автомобиля */
	DAMAGE_CAR(Role.ADMIN);                           
	
	/** Список ролей, которым доступны соответствующие команды */
	final Role[] accessRoles;
	
	/**
	 * Конструктор команд 
	 * 
	 * @param accessRoles роли, которым доступны команды
	 */
	private CommandName(Role... accessRoles) {
		this.accessRoles = accessRoles;
	}
	
	/**
	 * Метод для проверки прав доступа к соответствующей команде
	 * 
	 * @param role роль пользователя
	 * @return результат проверки прав доступа
	 */
	public boolean isAccessed(Role role) {
		if (accessRoles.length == 0) {
			return true;
		}
		for (Role accessRole : accessRoles) {
			if (accessRole.equals(role)) {
				return true;
			}
		}
		return false;
	}
}
