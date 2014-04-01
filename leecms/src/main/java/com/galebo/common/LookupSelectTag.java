package com.galebo.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.displaytag.tags.el.ExpressionEvaluator;

import com.galebo.lowyer.model.LabelValue;



public class LookupSelectTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4378793954187486312L;
	private String name;
	private String prompt;
	private String selected;
	private String code;
	private String onchange;
	private String disabled;
	

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}


	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getSelected() {
		return selected;
	}

	public void setDefault(String selected) {
		this.selected = selected;
	}

	public int doStartTag() throws JspException {
		ExpressionEvaluator eval = new ExpressionEvaluator(this, pageContext);

		if (selected != null) {
			selected = eval.evalString("default", selected);
		}

		List<LabelValue> beans = Select.getSelectValueLists(code);

		{
			StringBuffer sb = new StringBuffer();
			sb.append("<select name=\"").append(name).append("\" id=\"").append(name).append("\" class=\"select\" ");

			if (onchange != null) {
				sb.append(" onchange=\"").append(onchange).append("\" ");
			}
			if (disabled != null) {
				sb.append(" disabled=\"").append(disabled).append("\" ");
			}
			sb.append(">\n");

			if (prompt != null) {
				sb.append("    <option value=\"\" selected=\"selected\">");
				sb.append(eval.evalString("prompt", prompt)).append("</option>\n");
			}

			for (LabelValue bean : beans) {
				sb.append("<option value=\"").append(bean.getValue()).append("\"");
				if ((selected != null) && selected.equals(bean.getValue())) {
					sb.append(" selected=\"selected\"");
				}
				sb.append(">").append(bean.getLabel()).append("</option>\n");
			}

			sb.append("</select>");

			try {
				pageContext.getOut().write(sb.toString());
			} catch (IOException io) {
				throw new JspException(io);
			}
		}

		return super.doStartTag();
	}



	public void release() {
		super.release();
	}
}
