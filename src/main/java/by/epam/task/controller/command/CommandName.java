package by.epam.task.controller.command;

import by.epam.task.domain.Role;

/**
 * Перечисление все действий доступных на сайте
 *
 */
public enum CommandName {
	
	WRONG_REQUEST,                                    /** Обработка некорректных запросов */

	VIEW_CAR_LIST,                                    /** Отображение списка автомобилей */
	VIEW_CAR,                                         /** Отображение автомобиля */
	VIEW_MODIFY_CAR(Role.ADMIN),                      /** Отображение страницы для изменения автомобиля */
	MODIFY_CAR(Role.ADMIN),	                          /** Обработка запроса изменения автомобиля */
	DELETE_CAR(Role.ADMIN),	                          /** Обработка запроса удаления автомобиля */

	SIGN_UP(Role.ANONYMOUS),                          /** Обработка запроса регистрации пользователя */
	LOG_IN(Role.ANONYMOUS),                           /** Обработка запроса входа пользователя */
	LOG_OUT(Role.CUSTOMER, Role.ADMIN),               /** Обработка запроса выхода пользователя */
	MODIFY_USER(Role.CUSTOMER, Role.ADMIN),           /** Обработка запроса редактирования пользователя */
	
	VIEW_MODIFY_USER_ROOM(Role.CUSTOMER, Role.ADMIN), /** Отображение страницы пользователя */
	VIEW_USER_LIST(Role.ADMIN),                       /** Отображение списка пользователей */
	
	VIEW_DEAL_LIST(Role.ADMIN),                       /** Отображение списка сделок */
	VIEW_MODIFY_DEAL(Role.ADMIN, Role.CUSTOMER),      /** Отображение страницы редактирования сделки */
	
	MODIFY_DEAL(Role.CUSTOMER),                       /** Обработка запроса редактирования заказа*/
	DELETE_DEAL(Role.CUSTOMER),                       /** Обработка запроса удаления заказа */
	CONFIRM_DEAL(Role.ADMIN),                         /** Обработка запроса подтверждения заказа */
	CANCEL_DEAL(Role.ADMIN),                          /** Обработка запроса отмены заказа */
	PAY_DEAL(Role.CUSTOMER),                          /** Обработка запроса оплаты заказа */
	COMPLETE_DEAL(Role.ADMIN),                        /** Обработка запроса завершения сделки */
	DAMAGE_CAR(Role.ADMIN);                           /** Обработка запроса добавления повреждения автомобиля */
	
	/**
	 *	Список ролей, которым доступны соответствующие команды
	 */
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
