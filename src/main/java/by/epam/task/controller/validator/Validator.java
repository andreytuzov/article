package by.epam.task.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.cj.core.util.StringUtils;

import by.epam.task.domain.DealState;

/**
 * Класс для валидации параметров 
 */
public class Validator {
	
	/**
	 * Метод для валидации строки
	 * 
	 * @param str проверяемая строка
	 * @return результат валидации
	 */
	public static boolean isValidString(String str) {
		return !StringUtils.isNullOrEmpty(str);
	}
	
	/**
	 * Метод для валидации строки, длина которой больше min значения
	 * 
	 * @param str проверяемая строка
	 * @param min минимальная длина строки
	 * @return результат валидации
	 */
	public static boolean isValidString(String str, int min) {
		if (StringUtils.isNullOrEmpty(str) || str.length() < min) {
			return false;
		}
		return true;
	}
	
	/**
	 * Метод для валидации строки, длина которой находится в указанном диапазоне
	 * 
	 * @param str проверяемая строка
	 * @param min минимальная длина строки
	 * @param max максимальная длина строки
	 * @return результат валидации
	 */
	public static boolean isValidString(String str, int min, int max) {
		if (StringUtils.isNullOrEmpty(str) || str.length() < min || str.length() > max) {
			return false;
		}
		return true;
	}
	
	/**
	 * Метод для валидации строки, длина которой меньше указанное
	 * 
	 * @param str проверяемая строка
	 * @param max максимальная длина строки
	 * @return результат валидации
	 */
	public static boolean isValidLengthMax(String str, int max) {
		if (str != null && str.length() > max) {
			return false;
		}
		return true;
	}
	
	/**
	 * Метод для валидации целого числа
	 * 
	 * @param str целое число
	 * @return результат валидации
	 */
	public static boolean isValidInt(String str) {
		try {
			Integer.valueOf(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Метод для валидации вещественного числа
	 * 
	 * @param str вещественное число
	 * @return результат валидации
	 */
	public static boolean isValidFloat(String str) {
		try {
			Float.valueOf(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Метод для валидации даты
	 * 
	 * @param date дата
	 * @return результат валидации
	 */
	public static boolean isValidDate(String date) {
		Pattern pattern = Pattern.compile("^(19|20)\\d\\d/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])\\s([01][0-9]|2[0-3]):([0-5][0-9])$");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	
	/**
	 * Метод для валидации года
	 * 
	 * @param year год
	 * @return результат валидации
	 */
	public static boolean isValidYear(String year) {
		Pattern pattern = Pattern.compile("^(19|20)\\d\\d$");
		Matcher matcher = pattern.matcher(year);
		return matcher.matches();
	}
	
	/**
	 * Метод для валидации номера телефона
	 * 
	 * @param phone номер телефона
	 * @return результат валидации
	 */
	public static boolean isValidPhone(String phone) {
		Pattern pattern = Pattern.compile("^(\\+[0-9]+)?\\s?([0-9]{2,})?\\s?(\\d-?){4,}\\d$");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
	
	/**
	 * Метод для валидации электронного почтового адреса
	 * 
	 * @param email электронный почтовый адрес
	 * @return результат валидации
	 */
	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * Метод для валидации номера пасспорта
	 * 
	 * @param passportNumber номер пасспорта
	 * @return результат валидации
	 */
	public static boolean isValidPassportNumber(String passportNumber) {
		Pattern pattern = Pattern.compile("^[A-Za-zА-Яа-яЁё]{2,}\\s?\\d{6,}$");
		Matcher matcher = pattern.matcher(passportNumber);
		return matcher.matches();
	}
	
	/**
	 * Метод для валидации состояния заказа
	 * 
	 * @param dealState состояние заказа 
	 * @return результат валидации
	 */
	public static boolean isValidDealState(String dealState) {
		try {
			DealState.valueOf(dealState);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
}
