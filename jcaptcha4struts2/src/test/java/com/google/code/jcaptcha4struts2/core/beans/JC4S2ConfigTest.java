package com.google.code.jcaptcha4struts2.core.beans;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.BasicConfigurator;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.google.code.jcaptcha4struts2.core.PluginConstants;
import com.octo.captcha.service.image.ImageCaptchaService;
/**
 * JUnit Tests for JC4S2Config.
 * 
 * @author Yohan Liyanage
 * 
 * @since Aug 8, 2009
 * @version 1.0
 */
public class JC4S2ConfigTest {
	
	@Before
	public void initializeLogger() {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
	}
	
	/**
	 * Tests the {@link JC4S2Config} getInstance method.
	 */
	@Test
	public void testGetInstance() {
		JC4S2Config instance = JC4S2Config.getInstance();
		assertNotNull(instance);
	}

	/**
	 * Tests the default {@link JC4S2Config#getImageCaptchaService()) method.
	 */
	@Test
	public void testGetImageCaptchaService() throws Exception  {
		
		ImageCaptchaService service = JC4S2Config.getInstance().getImageCaptchaService();
		
		// Check whether reference is not null.
		assertNotNull(service);
		
		// Check whether the reference is of the default ImageCaptchaService type.
		Class<?> clazz = Class.forName(PluginConstants.DEFAULT_IMG_CAPTCHA_IMPL);
		assertTrue(clazz.isInstance(service));
	}

	/**
	 * Tests setImageCaptchaService to ensure that setting a custom ImageCaptchaService
	 * will always return the correct ImageCaptchaService.
	 */
	@Test
	public void testSetImageCaptchaService() {
		
		ImageCaptchaService mockService = EasyMock.createMock(ImageCaptchaService.class);
		// We expect nothing from mock.
		EasyMock.replay(mockService);
		
		JC4S2Config.getInstance().setImageCaptchaService(mockService);

		// See if the returned ImageCaptchaService is the same instance as mockService.
		assertTrue(JC4S2Config.getInstance().getImageCaptchaService() == mockService);
		
		// Verify mock
		EasyMock.verify(mockService);
	}

}
