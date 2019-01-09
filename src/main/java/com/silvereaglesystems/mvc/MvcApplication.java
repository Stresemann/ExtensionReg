package com.silvereaglesystems.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		if(System.getProperty("RUNNINGAS").equals("BROWSER")) {
			SpringApplication.run(MvcApplication.class, args);
		} else {
			TerminalRegistration tr = new TerminalRegistration();
			tr.showGreeting();
		}
		
	}

}

