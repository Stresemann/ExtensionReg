package com.silvereaglesystems.mvc.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.silvereaglesystems.mvc.models.Extension;
import com.vmware.automatic.plugin.registration.commands.IsPluginRegisteredCmd;
import com.vmware.automatic.plugin.registration.commands.PluginCmd;
import com.vmware.automatic.plugin.registration.commands.RegisterPluginCmd;
import com.vmware.automatic.plugin.registration.commands.UnregisterPluginCmd;
import com.vmware.automatic.plugin.registration.commands.UpdatePluginCmd;

@Service
public class RegisterService {
	private static final Map<String, PluginCmd> commands = new HashMap<String, PluginCmd>();
	static {
	      commands.put("registerPlugin", new RegisterPluginCmd());
	      commands.put("unregisterPlugin", new UnregisterPluginCmd());
	      commands.put("updatePlugin", new UpdatePluginCmd());
	      commands.put("isPluginRegistered", new IsPluginRegisteredCmd());
	   }
	
	public Extension pluginAction(Extension extension, String action, String url, String username, String password) {
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
    	args[1] = url;
    	args[2] = "-u";
    	args[3] = username;
    	args[4] = "-p";
    	args[5] = password;
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
