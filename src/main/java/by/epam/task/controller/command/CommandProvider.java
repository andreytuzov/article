package by.epam.task.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.impl.ViewArticleList;
import by.epam.task.controller.command.impl.WrongRequest;

public class CommandProvider {
	
	private static final Logger logger = Logger.getLogger(CommandProvider.class);
	
	private static final CommandProvider instance = new CommandProvider(); 
	
	private final Map<CommandName, ICommand> commands = new HashMap<>();
	
	private CommandProvider() {
		commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
		commands.put(CommandName.VIEW_ARTICLE_LIST, new ViewArticleList());
	}
	
	public ICommand getCommand(String key) {
		ICommand command = null;
		try {
			CommandName commandName = CommandName.valueOf(key.toUpperCase());
			command = commands.get(commandName);
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
