package com.galebo.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.displaytag.tags.el.ExpressionEvaluator;

import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.LabelValue;



public class LookupSelectTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4378793954187486312L;
	private String name;
	private String prompt;
	private String scope;
	private String selected;
	private String lookuptype;
	private String code;
	private String refresh;
	private String onchange;
	private String disabled;

	private String cssClass;
	

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}


	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getLookuptype() {
		return lookuptype;
	}

	public void setLookuptype(String lookuptype) {
		this.lookuptype = lookuptype;
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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
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

		List<LabelValue> beans = getSelectValueLists();

		if (scope != null) {
			if (scope.equals("page")) {
				pageContext.setAttribute(name, beans);
			} else if (scope.equals("request")) {
				pageContext.getRequest().setAttribute(name, beans);
			} else if (scope.equals("session")) {
				pageContext.getSession().setAttribute(name, beans);
			} else if (scope.equals("application")) {
				pageContext.getServletContext().setAttribute(name, beans);
			} else {
				throw new JspException("Attribute 'scope' must be: page, request, session or application");
			}
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("<select name=\"").append(name).append("\" id=\"").append(name).append("\" class=\"select\" ");

			if (onchange != null) {
				sb.append(" onchange=\"").append(onchange).append("\" ");
			}
			if (disabled != null) {
				sb.append(" disabled=\"").append(disabled).append("\" ");
			}
			if (cssClass != null) {
				sb.append(" cssClass=\"").append(cssClass).append("\" ");
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

	
	private List<LabelValue> getSelectValueLists() {
		List<LabelValue> result = new ArrayList<LabelValue>();
		if("Columns".equals(code)){
			List<ColColumn> beans=(List<ColColumn>)SpringContext.getSqlMapClientTemplate().queryForList("getColColumns");
			for(ColColumn bean:beans){
				LabelValue labelValue = new LabelValue();
				labelValue.setValue(""+bean.getColumnId());
				labelValue.setLabel(bean.getColName());
				result.add(labelValue);
			}
		}
		return result;
	}

	public void release() {
		super.release();
	}
}
