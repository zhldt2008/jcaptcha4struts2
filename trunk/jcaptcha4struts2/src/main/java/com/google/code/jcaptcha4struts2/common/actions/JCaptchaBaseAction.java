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
package com.google.code.jcaptcha4struts2.common.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.code.jcaptcha4struts2.core.validation.JCaptchaValidator;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This Action Class provides necessary functionality for handling JCaptcha content. This is to be
 * used as the superclass of an action class which handles JCaptcha related forms, if intercepters
 * are not being used.
 * <p>
 * <b>Note :</b> If intercepters are used, <b>do not use</b> this class as the base class. It would
 * result in exceptions (due to double validation of captcha).
 * 
 * @author Yohan Liyanage
 * @since 1.0
 * @version 2.0
 */
public class JCaptchaBaseAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(JCaptchaBaseAction.class);

	private static final long serialVersionUID = -5245380448623189946L;

	/**
	 * Stores the actual captcha response.
	 */
	private String j_captcha_response;
	
	/**
	 * Flag whether validation should be done.
	 */
	private boolean validate = true;

	/**
	 * No-args constructor. Builds a JCaptchaBaseAction which does the validation automatically
	 * through {@link #validate()} method.
	 */
	public JCaptchaBaseAction() {
		super();
	}

	/**
	 * Constructs a JCaptchaBaseAction which allows to enable / disable automatic validation through
	 * {@link #validate()}. If disabled, implementor is required to manually invoke
	 * {@link #doValidateCaptcha()} method for validation.
	 * <p>
	 * Subclasses may utilize this constructor to disable automatic validation.
	 * 
	 * @param validate
	 *            enable / disable auto-validation
	 */
	public JCaptchaBaseAction(boolean validate) {
		super();
		this.validate = validate;
	}

	/**
	 * Returns JCaptcha response by user.
	 * 
	 * @return jcaptcha response by user
	 */
	public String getJ_captcha_response() {
		return j_captcha_response;
	}

	/**
	 * Sets JCaptcha response by user.
	 * 
	 * @param j_captcha_response
	 *            response
	 */
	public void setJ_captcha_response(String j_captcha_response) {
		this.j_captcha_response = j_captcha_response;
	}

	/**
	 * Validates the JCaptcha response and adds a field error if validation fails, given that the
	 * validation is enabled (default case).
	 * <p>
	 * This method is final, and is not overridable. To provide your own validation logic, use the
	 * {@link #validateInput()} method.
	 */
	public final void validate() {

		if (validate) {
			doValidateCaptcha();
		} else {
			if (log.isDebugEnabled()) {
				log.debug("Skipping validation of captcha as validate=false");
			}
		}

		// Invoke user validation routines
		validateInput();
	}

	/**
	 * Validates the JCaptcha response and adds a field error if validation fails.
	 */
	protected void doValidateCaptcha() {

		if (log.isDebugEnabled()) {
			log.debug("Validating  : " + j_captcha_response);
		}

		if (!JCaptchaValidator.validate()) {
			if (log.isDebugEnabled()) {
				log.debug("validation failed, field error added");
			}
			addFieldError("j_captcha_response", "Invalid Captcha");
		}
	}

	/**
	 * Implementers may override this method to provide validation logic, instead of standard
	 * validate() method.
	 * <p>
	 * This method will be invoked from the validate() method, which is final in this class, and not
	 * overridable.
	 */
	public void validateInput() {
		// No-implementation
	}

}
