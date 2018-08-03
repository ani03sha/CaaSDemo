# CaaS Demo

Content as a Service is a concept in Headless CMS which allows the author to expose the JCR content in AEM as an API.

This projects showcases the demo of such functionality using the configuration.

### Steps to use
1. Build and install the project
2. Go to ./system/console/configMgr and search for "Content as a Service" config
3. Edit the config and put the URL of the page where the content model is configured and save.
4. Hit the servlet at - (http://<host>:<port>/bin/caas) 