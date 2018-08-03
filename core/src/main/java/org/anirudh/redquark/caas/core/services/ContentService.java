package org.anirudh.redquark.caas.core.services;

/**
 * 
 * @author Anirudh Sharma
 * 
 * This interface exposes the JCR content as a service
 *
 */
public interface ContentService {

	/**
	 * This abstract method returns the model data exposed by the JCR
	 * 
	 * @return {@code}
	 */
	public String getContentModel();
	
}
