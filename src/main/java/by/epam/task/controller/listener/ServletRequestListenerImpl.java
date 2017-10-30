package by.epam.task.controller.listener;

import java.util.Enumeration;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Класс для логирования событий создания и удаления запроса
 */
public class ServletRequestListenerImpl implements ServletRequestAttributeListener {

	private static final Logger logger = Logger.getLogger(ServletRequestListenerImpl.class);

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		logger.info(srae.getName() + " = " + srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		logger.info(srae.getName() + " = " + srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		logger.info(srae.getName() + " = " + srae.getValue());
	}

}
