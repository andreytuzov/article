package by.epam.task.controller.jsp.tag;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Jsp тэг для обрезания текста 
 */
public class TextTrimTag extends SimpleTagSupport {

	/** Суффикс для текста */
	private static final String START_TEXT = " ...";
	
	/** Аттрибут тэга - обрабатываемый текст */
	private String text;

	public TextTrimTag() {
	}

	/**
	 * Set-метод для записи текста в соответствующую переменную
	 * 
	 * @param text текст, записанный в атрибуте
	 */
	public void setText(String text) {
		this.text = text.trim();
	}

	/**
	 * Выполняем обрезание текста до ., ! или ?
	 */
	@Override
	public void doTag() throws JspException, IOException {
		String result = text;
		Pattern pattern = Pattern.compile("^.+?(?=[.!?])");
		Matcher matcher = pattern.matcher(text);		
		if (matcher.find()) {
			result = matcher.group(0);	
		}
		getJspContext().getOut().write(result + START_TEXT);
	}
	
}
