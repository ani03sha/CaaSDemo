/**
 * 
 */
package org.anirudh.redquark.caas.core.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.anirudh.redquark.caas.core.ContentServiceConfiguration;
import org.anirudh.redquark.caas.core.services.ContentService;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;

/**
 * @author Anirudh Sharma
 * 
 * Implementation of ContentService
 *
 */
@Component(service = ContentService.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = ContentServiceConfiguration.class)
public class ContentServiceImpl implements ContentService {
	
	private ContentServiceConfiguration configuration;
	
	@Activate
	public void activate(ContentServiceConfiguration configuration) {
		this.configuration = configuration;
	}

	public String getContentModel() {

		URL url;
		try {
			url = new URL(configuration.getURL());
			URLConnection uc;
			uc = url.openConnection();

			uc.setRequestProperty("X-Requested-With", "Curl");

			String userpass = "admin" + ":" + "admin";
			String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
			uc.setRequestProperty("Authorization", basicAuth);

			BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));

			}
			String result = builder.toString();
			JSONObject jsonObject = new JSONObject(result);

			return jsonObject.toString();

		} catch (IOException e) {
			e.printStackTrace();
			return "Error";
		}
	}

}
