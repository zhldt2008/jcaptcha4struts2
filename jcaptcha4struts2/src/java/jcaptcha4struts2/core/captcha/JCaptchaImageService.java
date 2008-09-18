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
package jcaptcha4struts2.core.captcha;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * JCaptcha Service Singleton. This class provides the access point
 * to JCaptcha services.
 * 
 * @author Yohan Liyanage
 *
 */
public class JCaptchaImageService {

	/**
	 * Singleton Instance
	 */
	private static final JCaptchaImageService instance = new JCaptchaImageService();

	// JCaptcha Service
	private DefaultManageableImageCaptchaService service = new DefaultManageableImageCaptchaService();
	
	/**
	 * No-instantiation
	 */
	private JCaptchaImageService() {
		super();
	}

	/**
	 * Returns the JCaptcha ImageCaptchaService implementation.
	 * 
	 * @return ImageCaptchaService
	 * @throws CaptchaServiceException
	 */
	public static ImageCaptchaService getService()  {
		return instance.service;
	}

	/**
	 * Returns the singleton instance of JCaptchaImageService.
	 * 
	 * @return instance
	 */
	public static JCaptchaImageService getInstance() {
		return instance;
	}

	/**
	 * Sets the JCaptcha Engine to a different implementation. Use this to
	 * configure the JCaptcha Service to render Captcha images using engines
	 * other than the default.
	 * 
	 * @param engine CaptchaEngine
	 */
	public void setEngine(CaptchaEngine engine) {
		service.setCaptchaEngine(engine);
	}
	
}
