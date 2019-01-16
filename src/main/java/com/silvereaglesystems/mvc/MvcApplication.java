package com.silvereaglesystems.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;

import com.silvereaglesystems.mvc.desktop.RegistrationDesktopView;
import com.silvereaglesystems.mvc.terminal.TerminalRegistration;

@SpringBootApplication
public class MvcApplication implements CommandLineRunner {
	@Autowired
	TerminalRegistration terminal;
	
	public static void main(String[] args) {
		try{
			if("BROWSER".equals(System.getProperty("RUNNINGAS"))) {
				SpringApplication.run(MvcApplication.class, args);
			} else if("TERMINAL".equals(System.getProperty("RUNNINGAS"))) {
				SpringApplication app = new SpringApplication(MvcApplication.class);
				app.setBannerMode(Banner.Mode.OFF);
				app.setWebApplicationType(WebApplicationType.NONE);
		        app.run(args);
			} else if("DESKTOP".equals(System.getProperty("RUNNINGAS"))) {
				RegistrationDesktopView dr = new RegistrationDesktopView();
				dr.showView();
			}
		} catch(Exception e){
			   e.printStackTrace();
		}
	}

	@Override
	public void run(String... args) throws Exception {
		if("DESKTOP".equals(System.getProperty("RUNNINGAS"))) {
			RegistrationDesktopView dr = new RegistrationDesktopView();
			dr.showView();
		} else if("TERMINAL".equals(System.getProperty("RUNNINGAS"))) {
			terminal.showGreeting();
		}
	}
}