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
package com.google.code.jcaptcha4struts2.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * JCaptcha Image UI Component Bean.
 * 
 * @author Yohan Liyanage
 * @since 1.0
 * @version 2.0
 */
public class JCaptchaImage extends UIBean {

    private String width;
    private String height;
    private String textSize;

    /**
     * Default Template Name.
     */
    private static final String TEMPLATE = "image";

    /**
     * JCaptchaImage UI Bean Constructor.
     * 
     * @param stack
     *            Struts 2 Value Stack
     * @param request
     *            HttpServletRequest object for invocation
     * @param response
     *            HttpServletResponse object for invocation
     */
    public JCaptchaImage(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    /**
     * Returns the Default Template Name for JCaptchaImage UI Bean.
     * 
     * @return default template name
     */
    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    /**
     * Returns width of the image displayed (pixels, specified in HTML attribute style).
     * 
     * @return width of image in pixels.
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the width of the image displayed (pixels, specified in HTML attribute style).
     * 
     * @param width
     *            width of image in pixels.
     */
    public void setWidth(String width) {
        this.width = width;
        addParameter("width", width);
    }

    /**
     * Returns the height of the image displayed (pixels, specified in HTML attribute style).
     * 
     * @return height of the image in pixels.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the height of the image displayed (pixels, specified in HTML attribute style).
     * 
     * @param height
     *            height of the image displayed in pixels
     */
    public void setHeight(String height) {
        this.height = height;
        addParameter("height", height);
    }

    /**
     * Returns the size of captcha input text field (HTML size attribute of text fields).
     * 
     * @return the size of captcha input text field.
     */
    public String getTextSize() {
        return textSize;
    }

    /**
     * Sets the size of captcha input text field (HTML size attribute of text fields).
     * 
     * @param textSize
     *            the size of captcha input text field.
     */
    public void setTextSize(String textSize) {
        this.textSize = textSize;
        addParameter("textSize", textSize);
    }

}
