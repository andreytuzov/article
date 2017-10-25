package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.User;

public interface UserDAO {

	User findOneByNicknameAndPassword(String nickname, String password) throws DAOException;

	List<User> findAll() throws DAOException;

	int insert(User user, String password) throws DAOException;

	User findOne(int id) throws DAOException;
}
