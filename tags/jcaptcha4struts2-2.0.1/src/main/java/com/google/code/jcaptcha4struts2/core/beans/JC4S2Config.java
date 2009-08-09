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
package com.google.code.jcaptcha4struts2.core.beans;

import static com.google.code.jcaptcha4struts2.core.PluginConstants.DEFAULT_IMG_CAPTCHA_IMPL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * JCaptcha4Struts2 Configuration.
 * <p>
 * This class holds the configuration settings for the plugin. It is possible to customize, override
 * the configuration using the singleton instance of this class. The singleton instance is
 * accessible via {@link #getInstance()} method.
 * 
 * @author Yohan Liyanage
 * 
 * @since 2.0
 * @version 2.0
 */
public final class JC4S2Config {

    /**
     * Logger for {@link JC4S2Config}.
     */
    private static final Log LOG = LogFactory.getLog(JC4S2Config.class);

    /**
     * Singleton Instance.
     */
    private static final JC4S2Config INSTANCE = new JC4S2Config();

    /**
     * ImageCaptchaService Implementation.
     */
    private ImageCaptchaService imageCaptchaService;

    /**
     * Returns the singleton instance of the {@link JC4S2Config} class.
     * 
     * @return singleton instance.
     */
    public static JC4S2Config getInstance() {
        return INSTANCE;
    }

    /**
     * No-args constructor. This is private to ensure that singleton state is maintained.
     */
    private JC4S2Config() {
        // Singleton
    }

    /**
     * Returns the {@link ImageCaptchaService} implementation.
     * 
     * @return ImageCapthcaService implementation
     */
    public ImageCaptchaService getImageCaptchaService() {

        synchronized (JC4S2Config.class) {
            /*
             * If ImageCaptchaService is not configured yet, fall-back to default. Locking is
             * necessary to ensure that only a single ImageCaptchaService is used to generate
             * captcha.
             */
            if (imageCaptchaService == null) {
                imageCaptchaService = getDefaultImageCaptchaService();
            }
        }

        return imageCaptchaService;
    }

    /**
     * Sets the {@link ImageCaptchaService} implementation.
     * 
     * @param imageCaptchaService
     *            ImageCapthcaService implementation
     */
    public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
        this.imageCaptchaService = imageCaptchaService;
    }

    /**
     * Returns the default {@link ImageCaptchaService} instance.
     * <p>
     * The default image captcha service is defined as a {@code PluginConstant}.
     * 
     * @return default {@link ImageCaptchaService} instance
     */
    private static ImageCaptchaService getDefaultImageCaptchaService() {

        try {
            Class<?> clazz = Class.forName(DEFAULT_IMG_CAPTCHA_IMPL);
            return (ImageCaptchaService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            // JCaptcha Implementation Class Missing !
            String msg = "Unable to find class for  : " + DEFAULT_IMG_CAPTCHA_IMPL;
            LOG.fatal(msg, e);
            throw new IllegalStateException(msg);
        } catch (InstantiationException e) {
            // Instantiation Failure
            String msg = "Unable to instantiate class : " + DEFAULT_IMG_CAPTCHA_IMPL;
            LOG.fatal(msg, e);
            throw new IllegalStateException(msg);
        } catch (IllegalAccessException e) {
            // Reflective Access Failure
            String msg = "Unable to instantiate class : " + DEFAULT_IMG_CAPTCHA_IMPL;
            LOG.fatal(msg, e);
            throw new IllegalStateException(msg);
        } catch (Exception e) {
            // Unknown Failure
            String msg = "Unable to instantiate class : " + DEFAULT_IMG_CAPTCHA_IMPL;
            LOG.fatal(msg, e);
            throw new IllegalStateException(msg);
        }
    }

}
