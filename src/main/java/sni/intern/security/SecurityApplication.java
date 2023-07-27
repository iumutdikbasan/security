package sni.intern.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sni.intern.security.domain.Role;
import sni.intern.security.domain.User;
import sni.intern.security.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Umut Dikbasan","iumutdikbasan","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Joseph Joestar","jojo","4321",new ArrayList<>()));
			userService.saveUser(new User(null, "Bruce Wayne","batman","2345",new ArrayList<>()));
			userService.saveUser(new User(null, "Din Djarin","mandalorian","5432",new ArrayList<>()));

			userService.addRoleToUser("mandalorian","ROLE_USER");
			userService.addRoleToUser("mandalorian","ROLE_MANAGER");
			userService.addRoleToUser("batman","ROLE_MANAGER");
			userService.addRoleToUser("jojo","ROLE_ADMIN");
			userService.addRoleToUser("iumutdikbasan","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("iumutdikbasan","ROLE_ADMIN");
			userService.addRoleToUser("iumutdikbasan","ROLE_SUPER");
		};
	}

}
