package by.epam.task.domain;

/**
 * Объект бизнес данных: роль пользователя
 */
public enum Role {
	
	/** Анонимный пользователь */
	ANONYMOUS(0), 
	/** Администратор */
	ADMIN(1), 
	/** Клиент */
	CUSTOMER(2);

	/** Индекс роли равный первичному ключу в таблице ролей */
	private final int index;

	Role(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
