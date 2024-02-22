package com.configuaration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDSConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringMVCConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		String[] allowedURIs = { "/" }; // all URI calls
		return allowedURIs;
	}

}
