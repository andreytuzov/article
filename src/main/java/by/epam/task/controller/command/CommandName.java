package by.epam.task.controller.command;

import by.epam.task.domain.Role;

public enum CommandName {
	
	WRONG_REQUEST,
	VIEW_CAR_LIST,
	VIEW_CAR,
	VIEW_MODIFY_CAR(Role.ADMIN),
	MODIFY_CAR(Role.ADMIN),
	DELETE_CAR(Role.ADMIN),
	
	VIEW_SIGN_UP(Role.ANONYMOUS),
	SIGN_UP(Role.ANONYMOUS),
	LOG_IN(Role.ANONYMOUS),
	VIEW_LOG_IN(Role.ANONYMOUS),
	LOG_OUT(Role.CUSTOMER, Role.ADMIN),
	
	VIEW_MODIFY_DEAL,
	
	MODIFY_DEAL(Role.CUSTOMER),
	CONFIRM_DEAL(Role.ADMIN),
	CANCEL_DEAL(Role.ADMIN),
	PAY_DEAL(Role.CUSTOMER),
	DAMAGE_CAR(Role.ADMIN);
	
	final Role[] accessRoles;
	
	private CommandName(Role... accessRoles) {
		this.accessRoles = accessRoles;
	}
	
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
