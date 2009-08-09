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

import com.opensymphony.xwork2.ActionSupport;

/**
 * Sample Action which uses interceptor for validation.
 * <p>
 * This is a plain old struts2 action, with no specific code regarding to JCaptcha4Struts2.
 * <p>
 * See the struts.xml file for custom interceptor configuration.
 * 
 * @author Yohan Liyanage
 * @since 1.0
 * @version 2.0
 */
public class FormActionWithIntercepter extends ActionSupport {

    private static final long serialVersionUID = 6643871470200594031L;

    private String text;

    /**
     * Returns the text provided by the user (using JSP).
     * 
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text provided by the user (using JSP).
     * 
     * @param text
     *            text
     */
    public void setText(String text) {
        this.text = text;
    }

}
