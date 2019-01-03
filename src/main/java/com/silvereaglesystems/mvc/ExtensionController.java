package com.silvereaglesystems.mvc;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silvereaglesystems.mvc.models.Extension;
import com.vmware.automatic.plugin.registration.commands.IsPluginRegisteredCmd;
import com.vmware.automatic.plugin.registration.commands.PluginCmd;
import com.vmware.automatic.plugin.registration.commands.RegisterPluginCmd;
import com.vmware.automatic.plugin.registration.commands.UnregisterPluginCmd;
import com.vmware.automatic.plugin.registration.commands.UpdatePluginCmd;

@RestController
public class ExtensionController {
	private static final Map<String, PluginCmd> commands = new HashMap<String, PluginCmd>();
	static {
	      commands.put("registerPlugin", new RegisterPluginCmd());
	      commands.put("unregisterPlugin", new UnregisterPluginCmd());
	      commands.put("updatePlugin", new UpdatePluginCmd());
	      commands.put("isPluginRegistered", new IsPluginRegisteredCmd());
	   }
    
    @RequestMapping(value="/extension", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Extension extension(@RequestBody(required = false) Extension extension, @RequestParam("action") String action) {
    	String[] args;
    	if(action.equals("registerPlugin")) {
    		args = new String[14];
    		args[10] = "-v";
        	args[11] = extension.getVersion();
        	args[12] = "-pu";
        	args[13] = extension.getClient().getUrl();
    	} else {
    		args = new String[10];
    	}
    	 
    	args[0] = "-url";
    	args[1] = System.getProperty("url");
    	args[2] = "-u";
    	args[3] = System.getProperty("username");
    	args[4] = "-p";
    	args[5] = System.getProperty("password");
    	args[6] = "-k";
    	args[7] = extension.getKey();
    	args[8] = "-action";
    	args[9] = action;

    	for (int i =0; i< args.length; i++) {
 		   System.out.println(args[i]);
 	   }
    	PluginCmd pluginCmd = commands.get(action);
    	pluginCmd.execute(args);
        return extension;
    }
}
