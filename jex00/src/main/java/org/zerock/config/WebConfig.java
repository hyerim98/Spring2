package org.zerock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
	* web.xml을 대신하는 class
*/

@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	// root-context.xml을 대신하는 클래스를 지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// RootConfig.java 클래스를 사용함
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return null;
	}

}
