package com.silvereaglesystems.mvc;

import java.util.Scanner;

import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Extension;
import com.silvereaglesystems.mvc.services.RegisterService;

public class TerminalRegistration {
	public void showGreeting() {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Please enter the username, password, and URL of your vCenter.");
		System.out.println("username: ");
		String username = reader.nextLine();
		System.out.println("password: ");
		String password = reader.nextLine();
		System.out.println("url: ");
		String url = reader.nextLine();
		System.out.println(username + " test ");
		
		Extension extension = new Extension();
		extension.setKey("1.0.0");
		extension.setVersion("1.0.0");
		RegisterService registerService = new RegisterService();
		Client client = new Client();
    	client.setUrl("https://www.google.com/");
    	extension.setClient(client);
    	registerService.pluginAction(extension, "registerPlugin", url, username, password);
		reader.close();
	}
}
