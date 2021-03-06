package by.epam.task.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.command.impl.CancelDeal;
import by.epam.task.controller.command.impl.CompleteDeal;
import by.epam.task.controller.command.impl.ConfirmDeal;
import by.epam.task.controller.command.impl.DamageCar;
import by.epam.task.controller.command.impl.DeleteCar;
import by.epam.task.controller.command.impl.DeleteDeal;
import by.epam.task.controller.command.impl.LogIn;
import by.epam.task.controller.command.impl.LogOut;
import by.epam.task.controller.command.impl.ModifyCar;
import by.epam.task.controller.command.impl.ModifyDeal;
import by.epam.task.controller.command.impl.ModifyUser;
import by.epam.task.controller.command.impl.PayDeal;
import by.epam.task.controller.command.impl.SignUp;
import by.epam.task.controller.command.impl.WrongRequest;
import by.epam.task.controller.command.impl.view.ViewCar;
import by.epam.task.controller.command.impl.view.ViewCarList;
import by.epam.task.controller.command.impl.view.ViewDealList;
import by.epam.task.controller.command.impl.view.ViewModifyCar;
import by.epam.task.controller.command.impl.view.ViewModifyDeal;
import by.epam.task.controller.command.impl.view.ViewUserList;
import by.epam.task.controller.validator.Validator;
import by.epam.task.controller.command.impl.view.ViewModifyUserRoom;
import by.epam.task.domain.Role;

/**
 *	Класс для хранения и полуения объектов-команд
 *
 */
public class CommandProvider {

	/** Объект для логгирования */
	private static final Logger logger = Logger.getLogger(CommandProvider.class);

	/** Экземпляр объекта провайдера команд */
	private static final CommandProvider instance = new CommandProvider();

	/** Карта, в которой ключ - название команды, а значение - объект-команда  */
	private final Map<CommandName, ICommand> commands = new HashMap<>();

	/**
	 * Производиться заполнение карты команд
	 */
	private CommandProvider() {
		commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
		commands.put(CommandName.VIEW_CAR_LIST, new ViewCarList());
		commands.put(CommandName.VIEW_CAR, new ViewCar());

		commands.put(CommandName.VIEW_MODIFY_CAR, new ViewModifyCar());
		commands.put(CommandName.MODIFY_CAR, new ModifyCar());
		commands.put(CommandName.DELETE_CAR, new DeleteCar());

		commands.put(CommandName.SIGN_UP, new SignUp());
		commands.put(CommandName.LOG_IN, new LogIn());
		commands.put(CommandName.LOG_OUT, new LogOut());
		commands.put(CommandName.MODIFY_USER, new ModifyUser());
		 
		commands.put(CommandName.VIEW_MODIFY_USER_ROOM, new ViewModifyUserRoom());
		commands.put(CommandName.VIEW_USER_LIST, new ViewUserList());

		commands.put(CommandName.VIEW_DEAL_LIST, new ViewDealList());
		commands.put(CommandName.VIEW_MODIFY_DEAL, new ViewModifyDeal());
		
		commands.put(CommandName.MODIFY_DEAL, new ModifyDeal());
		commands.put(CommandName.CONFIRM_DEAL, new ConfirmDeal());
		commands.put(CommandName.DELETE_DEAL, new DeleteDeal());
		commands.put(CommandName.CANCEL_DEAL, new CancelDeal());
		commands.put(CommandName.PAY_DEAL, new PayDeal());
		commands.put(CommandName.COMPLETE_DEAL, new CompleteDeal());
		commands.put(CommandName.DAMAGE_CAR, new DamageCar());
	}
	
	/**
	 * Метод для полученя объекта-команды с учетом роли пользователя 
	 * 
	 * @param key имя команды
	 * @param role роль пользователя
	 * @return объект-команда
	 * @throws CommandException если пользователь с указанной ролью не имеет доступа к команде
	 */
	public ICommand getCommand(String key, Role role) throws CommandException {
		ICommand command = null;
		try {
			// Data validation
			if (!Validator.isValidString(key)) {
				logger.error("Action must not be empty");
				command = commands.get(CommandName.WRONG_REQUEST);
			} else {
				CommandName commandName = CommandName.valueOf(key.toUpperCase());
				if (role == null) {
					role = Role.ANONYMOUS;
				}
				if (commandName.isAccessed(role)) {
					command = commands.get(commandName);
				} else {
					throw new CommandException("User don't have permission to access on this page");
				}
			}
		} catch (IllegalArgumentException e) {
			logger.error("Error getting command", e);
			command = commands.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

	/**
	 * Получение экзепляра провайдера команд
	 *  
	 * @return экземпляр провайдера команд
	 */
	public static CommandProvider getInstance() {
		return instance;
	}

}
