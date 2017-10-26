package by.epam.task.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.mysql.cj.core.util.StringUtils;

public class Validator {

	private static final Logger logger = Logger.getLogger(Validator.class);
	
	public static boolean isValidString(String str) {
		return !StringUtils.isNullOrEmpty(str);
	}
	
	public static boolean isValidString(String str, int min) {
		if (StringUtils.isNullOrEmpty(str) || str.length() < min) {
			logger.debug("isValidString is false:" + str);
			return false;
		}
		logger.debug("isValidString is success:" + str);
		return true;
	}
	
	
	public static boolean isValidString(String str, int min, int max) {
		if (StringUtils.isNullOrEmpty(str) || str.length() < min || str.length() > max) {
			logger.debug("isValidString is false:" + str);
			return false;
		}
		logger.debug("isValidString is success:" + str);
		return true;
	}
	
	public static boolean isValidLengthMax(String str, int max) {
		if (str != null && str.length() > max) {
			logger.debug("isValidString is false:" + str);
			return false;
		}
		logger.debug("isValidString is success:" + str);
		return true;
	}
	
	public static boolean isValidInt(String str) {
		try {
			Integer.valueOf(str);
		} catch (NumberFormatException e) {
			logger.debug("isValidInt is error:" + str);
			return false;
		}
		logger.debug("isValidInt is success:" + str);
		return true;
	}
	
	public static boolean isValidFloat(String str) {
		try {
			Float.valueOf(str);
		} catch (NumberFormatException e) {
			logger.debug("isValidFloat is false:" + str);
			return false;
		}
		logger.debug("isValidFloat is success:" + str);
		return true;
	}
	
	public static boolean isValidDate(String date) {
		Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d\\s([01][0-9]|2[0-3]):([0-5][0-9])$");
		Matcher matcher = pattern.matcher(date);
		logger.debug("isValidDate is " + matcher.matches() + ":" + date + "'");
		return matcher.matches();
	}
	
	public static boolean isValidYear(String year) {
		Pattern pattern = Pattern.compile("^(19|20)\\d\\d$");
		Matcher matcher = pattern.matcher(year);
		logger.debug("isValidYear is " + matcher.matches() + ":" + year);
		return matcher.matches();
	}
	
	public static boolean isValidPhone(String phone) {
		Pattern pattern = Pattern.compile("^[\\s0-9()+-]{6,}$");
		Matcher matcher = pattern.matcher(phone);
		logger.debug("isValidPhone is " + matcher.matches() + ": " + phone);
		return matcher.matches();
	}
	
	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
		Matcher matcher = pattern.matcher(email);
		logger.debug("isValidEmail is " + matcher.matches() + ": " + email);
		return matcher.matches();
	}
	
}
