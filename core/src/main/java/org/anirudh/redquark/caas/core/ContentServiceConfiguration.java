package org.anirudh.redquark.caas.core;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * @author Anirudh Sharma
 * 
 * This interface represents the configuration for the CaaS
 */
@ObjectClassDefinition(name = "Content As A Service", description = "Service Configuration")
public @interface ContentServiceConfiguration {

	/**
	 * This abstract method gets the URL of the page
	 */
	@AttributeDefinition(name = "Config Value", description = "Configuration value")
	public String getURL();
}
