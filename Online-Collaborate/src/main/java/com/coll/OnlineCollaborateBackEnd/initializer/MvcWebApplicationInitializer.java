package com.coll.OnlineCollaborateBackEnd.initializer;
import java.io.File;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.coll.OnlineCollaborateBackEnd.config.MvcConfig;
import com.coll.OnlineCollaborateBackEnd.config.WebSocketChatConfig;
import com.coll.OnlineCollaborateBackEnd.filter.CORSFilter;
import com.coll.OnlineCollaborateBackEnd.config.EmailConfig;
import com.coll.OnlineCollaborateBackEnd.config.HibernateConfig;
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
   /*@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }*/
	/*if application is running on a Tomcat container. It says that asynchronous communication is possible, 
	 * so that connections do not have to be closed directly.
	*/
	@Override
	  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		//Allow asynchronous process
	    registration.setInitParameter("dispatchOptionsRequest", "true");
	    registration.setAsyncSupported(true);
	    
	    // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
				
		registration.setMultipartConfig(multipartConfigElement);
		super.customizeRegistration(registration);
	  }
    
    @Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {HibernateConfig.class, EmailConfig.class, WebSocketChatConfig.class};
	}

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    @Override
    protected Filter[] getServletFilters() {
    	/*CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());//all content will be in UTF-8
*/    	return new Filter[]{ new CORSFilter()};
    }
}