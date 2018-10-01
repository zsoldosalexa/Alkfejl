package hu.elte.WashingMachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WashingMachineApplication  extends SpringBootServletInitializer {

	public static void main(String[] args)  {
		SpringApplication.run(WashingMachineApplication.class, args);
	}
}
