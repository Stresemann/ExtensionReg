package com.silvereaglesystems.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Description;
import com.silvereaglesystems.mvc.models.Extension;

@Service
@PropertySource("plugin.properties")
public class ExtensionService {
	@Autowired
    private Environment env; 
	
	public Extension getDefaultExtension() {
		Extension extension = new Extension();
		extension.setClient(new Client());
		extension.setDescription(new Description());
		extension.setCompany(env.getProperty("plugin.company"));
		extension.setKey(env.getProperty("plugin.key"));
		extension.setVersion(env.getProperty("plugin.version"));
		extension.getClient().setUrl(env.getProperty("plugin.client.url"));
		extension.getDescription().setSummary(env.getProperty("plugin.description.summary"));
		return extension;
	}
}
