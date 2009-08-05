/*
 * Copyright (C) 2008 Yohan Liyanage. 
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
package jcaptcha4struts2.core.validation;

import jcaptcha4struts2.core.captcha.JCaptchaImageService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.octo.captcha.service.CaptchaServiceException;

/**
 * JCaptcha Validation Support. This class contains methods to
 * allow users to validate whether the response from captcha 
 * is correct or not.
 * 
 * @author Yohan Liyanage (yohanliyanage@gmail.com)
 *
 */
public class JCaptchaValidator {

	private static Log log = LogFactory.getLog(JCaptchaValidator.class);
	
	/**
	 * No-instantiation.
	 */
	private JCaptchaValidator() {
		super();
	}

	/**
	 * Validates whether captcha response was correct. 
	 * 
	 * @return true if correct, false otherwise
	 */
	public static boolean validate() throws CaptchaServiceException {
		
		String captchaId = ServletActionContext.getRequest().getSession().getId();
		String response = ServletActionContext.getRequest().getParameter("j_captcha_response");
		
		// If user response is not available in request parameters
		if (response==null) {
			throw new CaptchaServiceException("No JCaptcha Response Found [j_captcha_response=null]");
		}
		
		try {
			return JCaptchaImageService.getService().validateResponseForID(captchaId, response);
		} catch (CaptchaServiceException e) {
			log.error("Error validating captcha [id=" + captchaId + ", response=" + response + "]",e);
			throw e;
		}
	}
}
