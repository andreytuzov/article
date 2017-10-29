package by.epam.task.controller.jsp.tag;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TextTrimTag extends SimpleTagSupport {

	private static final String START_TEXT = " ...";
	
	private String text;

	public TextTrimTag() {
	}
	
	public void setText(String text) {
		this.text = text.trim();
	}

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
