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
package com.google.code.jcaptcha4struts2.core.validation;
import static com.google.code.jcaptcha4struts2.core.PluginConstants.J_CAPTCHA_RESPONSE;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.google.code.jcaptcha4struts2.core.beans.JC4S2Config;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * JCaptcha Validation Support. This class contains methods to allow users to validate whether the
 * response from captcha is correct or not.
 * 
 * @author Yohan Liyanage
 * @since 1.0
 * @version 2.0
 */
public final class JCaptchaValidator {

    private static final Log LOG = LogFactory.getLog(JCaptchaValidator.class);

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
     * @throws CaptchaServiceException
     *             <ul>
     *             <li>If {@code j_captcha_response} is not present in request parameters.</li>
     *             <li>If the image captcha service implementation throws this exception at the time
     *             of response validation.</li>
     *             </ul>
     */
    public static boolean validate() throws CaptchaServiceException {

        String captchaId = ServletActionContext.getRequest().getSession().getId();
        String response =
                ServletActionContext.getRequest().getParameter(J_CAPTCHA_RESPONSE);

        // If user response is not available in request parameters
        if (response == null) {
            throw new CaptchaServiceException(
                    "No JCaptcha Response Found [j_captcha_response=null]");
        }

        try {
            // Validate Captcha Response via ImageCaptchaService Implementation.
            return getImageCaptchaService().validateResponseForID(captchaId, response)
                    .booleanValue();
        } catch (CaptchaServiceException e) {
            LOG.error("Error validating captcha [id=" + captchaId + ", response=" + response + "]",
                    e);
            throw e;
        }
    }

    /**
     * Returns the {@link ImageCaptchaService} implementation, obtained via {@link JC4S2Config}.
     * 
     * @return {@link ImageCaptchaService} implementation.
     */
    private static ImageCaptchaService getImageCaptchaService() {
        return JC4S2Config.getInstance().getImageCaptchaService();
    }
}
