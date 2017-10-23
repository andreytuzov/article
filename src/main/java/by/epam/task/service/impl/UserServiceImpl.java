package by.epam.task.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.epam.task.dao.UserDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
	
	@Override
	public User findOneByNicknameAndPassword(String nickname, String password) throws ServiceException {
		try {
			return userDAO.findOneByNicknameAndPassword(nickname, password);
		} catch (DAOException e) {
			throw new ServiceException("Error executing findOneByUsername method", e);
		}
	}

	@Override
	public List<User> findAll() throws ServiceException {
		try {
			return userDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Error executing findAll method", e);
		}
	}
	
	@Override
	public int insert(User user, String password) throws ServiceException {
		int id = 0;
		try {
			if (null == userDAO.findOneByNicknameAndPassword(user.getNickname(), password)) {
				logger.debug(userDAO.findOneByNicknameAndPassword(user.getNickname(), password));
				id = userDAO.insert(user, password);
			} else {
				throw new ServiceException("The user with that username exists");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error executing signUp method", e);
		} 
		return id;
	}

}
