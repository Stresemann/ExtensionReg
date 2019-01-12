package com.silvereaglesystems.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.silvereaglesystems.mvc.desktop.RegistrationDesktopView;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		if(System.getProperty("RUNNINGAS").equals("BROWSER")) {
			SpringApplication.run(MvcApplication.class, args);
		} else if("DESKTOP".equals(System.getProperty("RUNNINGAS"))) {
			RegistrationDesktopView dr = new RegistrationDesktopView();
			dr.showView();
		} else {
			TerminalRegistration tr = new TerminalRegistration();
			tr.showGreeting();
		}
		
	}

}

