/**
 * 
 */
package org.anirudh.redquark.caas.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.anirudh.redquark.caas.core.services.ContentService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 *
 */
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Fetch Store Info",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/caas" })
public class FetchStoreInfoServlet extends SlingAllMethodsServlet {

	/**
	 * Default logger
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 5400377009084523447L;

	@Reference
	private ContentService service;

	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) {

		try {
			response.getWriter().println(service.getContentModel());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}
}
