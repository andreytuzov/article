package by.epam.task.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.exception.AccessCommandException;
import by.epam.task.controller.command.impl.DeleteCar;
import by.epam.task.controller.command.impl.LogIn;
import by.epam.task.controller.command.impl.LogOut;
import by.epam.task.controller.command.impl.ModifyCar;
import by.epam.task.controller.command.impl.SignUp;
import by.epam.task.controller.command.impl.ViewCar;
import by.epam.task.controller.command.impl.ViewCarList;
import by.epam.task.controller.command.impl.ViewLogIn;
import by.epam.task.controller.command.impl.ViewModifyCar;
import by.epam.task.controller.command.impl.ViewModifyDeal;
import by.epam.task.controller.command.impl.ViewSignUp;
import by.epam.task.controller.command.impl.WrongRequest;
import by.epam.task.domain.Role;

public class CommandProvider {
	
	private static final Logger logger = Logger.getLogger(CommandProvider.class);
	
	private static final CommandProvider instance = new CommandProvider(); 
	
	private final Map<CommandName, ICommand> commands = new HashMap<>();
	
	private CommandProvider() {
		commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
		commands.put(CommandName.VIEW_CAR_LIST, new ViewCarList());
		commands.put(CommandName.VIEW_CAR, new ViewCar());
		
		commands.put(CommandName.VIEW_MODIFY_CAR, new ViewModifyCar());
		commands.put(CommandName.MODIFY_CAR, new ModifyCar());
		commands.put(CommandName.DELETE_CAR, new DeleteCar());
		
		commands.put(CommandName.SIGN_UP, new SignUp());
		commands.put(CommandName.VIEW_SIGN_UP, new ViewSignUp());
		commands.put(CommandName.LOG_IN, new LogIn());
		commands.put(CommandName.VIEW_LOG_IN, new ViewLogIn());
		commands.put(CommandName.LOG_OUT, new LogOut());
		
		commands.put(CommandName.VIEW_MODIFY_DEAL, new ViewModifyDeal());
	}
	
	public ICommand getCommand(String key, Role role) throws AccessCommandException{
		ICommand command = null;
		try {
			CommandName commandName = CommandName.valueOf(key.toUpperCase());
			if (commandName.isAccessed(role)) {
				command = commands.get(commandName);
			} else {
				throw new AccessCommandException("User don't have permission to access on this page");
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			logger.error("Error getting command", e);
			command = commands.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
	
	public static CommandProvider getInstance() {
		return instance;
	}
	
}
