/*
 * Copyright (C) 2008-2009 Yohan Liyanage. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.google.code.jcaptcha4struts2.demo.actions;

import com.google.code.jcaptcha4struts2.common.actions.JCaptchaBaseAction;

/**
 * Sample Action which does not use interceptors. Instead,
 * it extends from JCaptchaBaseAction class, which provides
 * support for handling captcha responses.

 * @author Yohan Liyanage
 * @since 1.0
 * @version 2.0
 */
public class FormActionNoIntercepter extends JCaptchaBaseAction {

	private static final long serialVersionUID = 6643871470200594031L;
	
	private String text;

	/**
	 * Standard Action Execution Method
	 * 
	 * @return action forward
	 * @throws Exception if thrown by the ActionSupport execute method
	 */
	public String execute() throws Exception {
		return super.execute();
	}
	
	/**
	 * Custom validation logic.
	 */
	public void validateInput() {
		// Validation Logic Here
		
		// Note that you cannot override validate() method (it's final).
		// Instead, the logic should be provided in this method.
		
		// You may utilize standard Struts 2 validation error API 
		// to provide validation failure notifications (ex. addFieldError).
	}

	/**
	 * Returns the text provided by the user (using JSP).
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text provided by the user (using JSP).
	 * @param text text
	 */
	public void setText(String text) {
		this.text = text;
	}

	
}
