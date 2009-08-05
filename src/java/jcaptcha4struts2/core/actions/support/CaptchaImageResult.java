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
package jcaptcha4struts2.core.actions.support;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import jcaptcha4struts2.core.actions.JCaptchaImageAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * Struts2 Result Type for JCaptcha Image.
 *  
 * @author Yohan Liyanage
 *
 */
public class CaptchaImageResult implements Result {

	private static final long serialVersionUID = -595342817673304030L;

	/**
	 * Action Execution Result. This will write the image bytes
	 * to response stream.
	 * 
	 * @param invocation ActionInvocation
	 */
	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		
		// Check if the invoked action was JCaptchaImageAction
		if (!(invocation.getAction() instanceof JCaptchaImageAction)) {
			throw new IllegalStateException("CaptchaImageResult expects JCaptchaImageAction as Action Invocation");
		}
		
		JCaptchaImageAction action = (JCaptchaImageAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// Read captcha image bytes
		byte[] image = action.getCaptchaImage();

		// Send response
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		response.setContentLength(image.length);
		response.getOutputStream().write(image);
		response.getOutputStream().flush();
	}

}
