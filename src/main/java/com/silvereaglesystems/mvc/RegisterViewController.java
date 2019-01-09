package com.silvereaglesystems.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Extension;
import com.silvereaglesystems.mvc.services.RegisterService;

@Controller
@SessionAttributes("name")
public class RegisterViewController {

    @Autowired
    RegisterService registerService;
    
    @ModelAttribute("extension")
    public Extension getExtensionObject() {
     return new Extension();
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @ModelAttribute("extension")Extension extension, BindingResult result,
    		@RequestParam String username, @RequestParam String password, @RequestParam String url){
    	if(result.hasErrors()) {
    		System.err.println(result.getFieldError());
    	}
    	Client client = new Client();
    	client.setUrl("https://www.google.com/");
    	extension.setClient(client);
    	registerService.pluginAction(extension, "registerPlugin", url, username, password);
    	
        return "welcome";
    }

}