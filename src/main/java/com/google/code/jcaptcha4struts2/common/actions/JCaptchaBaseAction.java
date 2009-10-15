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

import com.google.code.jcaptcha4struts2.core.PluginConstants;
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

    private static final Log LOG = LogFactory.getLog(JCaptchaBaseAction.class);

    private static final long serialVersionUID = -5245380448623189946L;

    /**
     * Stores the actual captcha response.
     */
    private String jCaptchaResponse;

    /**
     * Flag whether validation should be done.
     */
    private boolean validationEnabled = true;

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
     * @param validationEnabled
     *            enable / disable auto-validation
     */
    public JCaptchaBaseAction(boolean validationEnabled) {
        super();
        this.validationEnabled = validationEnabled;
    }

    /**
     * Returns JCaptcha response by user.
     * 
     * @return jcaptcha response by user
     */
    public String getJCaptchaResponse() {
        return jCaptchaResponse;
    }

    /**
     * Sets JCaptcha response by user.
     * 
     * @param jCaptchaResponse
     *            jcaptcha response by user
     */
    public void setJCaptchaResponse(String jCaptchaResponse) {
        this.jCaptchaResponse = jCaptchaResponse;
    }

    /**
     * Validates the JCaptcha response and adds a field error if validation fails, given that the
     * validation is enabled (default case).
     * <p>
     * This method is final, and is not overridable. To provide your own validation logic, use the
     * {@link #validateInput()} method.
     */
    public final void validate() {

        if (validationEnabled) {
            doValidateCaptcha();
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Skipping validation of captcha as validate=false");
            }
        }

        // Invoke user validation routines
        validateInput();
    }

    /**
     * Validates the JCaptcha response and adds a field error if validation fails.
     */
    protected void doValidateCaptcha() {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Validating  : " + jCaptchaResponse);
        }

        if (!JCaptchaValidator.validate()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("validation failed (input string : '" + jCaptchaResponse
                        + "'), field error added");
            }
            addFieldError(PluginConstants.J_CAPTCHA_RESPONSE, getValidationErrorMessage());
        }
    }

    /**
     * Returns the error message text to be displayed if captcha validation fails.
     * <p>
     * Developers may override this method to provide custom messages.
     * 
     * @return error message to be displayed if captcha validation fails.
     */
    protected String getValidationErrorMessage() {
        return "Entered string does not match with image";
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

    /**
     * Returns true if automatic validation is enabled.
     * 
     * @return true if automatic validation is enabled.
     */
    public boolean isValidationEnabled() {
        return validationEnabled;
    }

    /**
     * Sets whether automatic validation is enabled.
     * 
     * @param validationEnabled if true, automatic validation will be enabled.
     */
    public void setValidationEnabled(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }

    
}
