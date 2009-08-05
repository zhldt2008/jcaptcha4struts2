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
package jcaptcha4struts2.core.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;

import jcaptcha4struts2.core.captcha.JCaptchaImageService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * This Action generates the Captcha Image.
 * 
 * @author Yohan Liyanage
 */
public class JCaptchaImageAction extends ActionSupport {

	private static final long serialVersionUID = 563498642053643243L;

	private byte[] captchaImage;

	@Override
	public String execute() throws Exception {

		ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		// Captcha Id is the session ID
		String captchaId = request.getSession().getId();
		
		// Generate Captcha Image
		BufferedImage image = JCaptchaImageService.getService()
				.getImageChallengeForID(captchaId, request.getLocale());
		
		// Convert to JPEG
		JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(imageOut);
		jpegEncoder.encode(image);
		
		// Get byte[] for image
		captchaImage = imageOut.toByteArray();
		
		return SUCCESS;
	}

	public byte[] getCaptchaImage() {
		return captchaImage;
	}

}
