package by.epam.task.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.impl.GetArticleList;
import by.epam.task.controller.command.impl.WrongRequest;

public class CommandProvider {
	
	private static final Logger logger = Logger.getLogger(CommandProvider.class);
	
	private static final CommandProvider instance = new CommandProvider(); 
	
	private final Map<CommandName, ICommand> repository = new HashMap<>();
	
	private CommandProvider() {
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.GET_ARTICLE_LIST, new GetArticleList());
	}
	
	public ICommand getCommand(String key) {
		logger.debug("key = " + key);
		ICommand command = null;
		try {
			CommandName commandName = CommandName.valueOf(key.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			logger.error("Error getting command", e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
	
	public static CommandProvider getInstance() {
		return instance;
	}
	
}
