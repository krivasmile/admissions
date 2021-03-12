package ua.kyiv.admissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ua.kyiv.admissions"})
public class AdmissionsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdmissionsApplication.class, args);
	}

}
