package com.silvereaglesystems.mvc.terminal;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Extension;
import com.silvereaglesystems.mvc.services.ExtensionService;
import com.silvereaglesystems.mvc.services.RegisterService;

@Service
public class TerminalRegistration {
	@Autowired
	ExtensionService extensionService;
	@Autowired
	RegisterService registerService;
	
	public void showGreeting() {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Please enter the username, password, and URL of your vCenter.");
		System.out.println("username: ");
		String username = reader.nextLine();
		System.out.println("password: ");
		String password = reader.nextLine();
		System.out.println("url: ");
		String url = reader.nextLine();
		
		Extension extension = extensionService.getDefaultExtension();
    	registerService.pluginAction(extension, "registerPlugin", url, username, password);
		reader.close();
		
	}
}
