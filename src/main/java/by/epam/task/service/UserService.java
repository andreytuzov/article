package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.User;
import by.epam.task.service.exception.ServiceException;

public interface UserService {	
	User findOneByNicknameAndPassword(String nickname, String password) throws ServiceException;

	List<User> findAll() throws ServiceException;
	
	int insert(User user, String password) throws ServiceException;	
}
