package com.silvereaglesystems.mvc;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vmware.automatic.plugin.registration.PluginRegistrationMain;
import com.vmware.automatic.plugin.registration.commands.IsPluginRegisteredCmd;
import com.vmware.automatic.plugin.registration.commands.PluginCmd;
import com.vmware.automatic.plugin.registration.commands.RegisterPluginCmd;
import com.vmware.automatic.plugin.registration.commands.UnregisterPluginCmd;
import com.vmware.automatic.plugin.registration.commands.UpdatePluginCmd;
import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Description;
import com.silvereaglesystems.mvc.models.Extension;

@RestController
public class GreetingsController {
	private static final Map<String, PluginCmd> commands = new HashMap<String, PluginCmd>();
	static {
	      commands.put("registerPlugin", new RegisterPluginCmd());
	      commands.put("unregisterPlugin", new UnregisterPluginCmd());
	      commands.put("updatePlugin", new UpdatePluginCmd());
	      commands.put("isPluginRegistered", new IsPluginRegisteredCmd());
	   }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/extension", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Extension extension(@RequestBody(required = false) Extension extension, @RequestParam("action") String action) {
    	String[] args = new String[14];
    	args[0] = "-url";
    	args[1] = System.getProperty("url");
    	args[2] = "-u";
    	args[3] = System.getProperty("username");
    	args[4] = "-p";
    	args[5] = System.getProperty("password");
    	args[6] = "-k";
    	args[7] = extension.getKey();
    	args[8] = "-v";
    	args[9] = extension.getVersion();
    	args[10] = "-action";
    	args[11] = action;
    	args[12] = "-pu";
    	args[13] = extension.getClient().getUrl();

    	for (int i =0; i< args.length; i++) {
 		   System.out.println(args[i]);
 	   }
    	PluginCmd pluginCmd = commands.get(action);
    	pluginCmd.execute(args);
        return extension;
    }
}
