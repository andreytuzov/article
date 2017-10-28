package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.User;
import by.epam.task.service.exception.ServiceException;

public interface UserService {	
	
	User findOneByNickname(String nickname) throws ServiceException;
	
	User findOneByNicknameAndPassword(String nickname, String password) throws ServiceException;

	List<User> findAll() throws ServiceException;
	
	int add(User user, String password) throws ServiceException;
	
	void update(User user) throws ServiceException;
	
	User findOne(int id) throws ServiceException;
}
