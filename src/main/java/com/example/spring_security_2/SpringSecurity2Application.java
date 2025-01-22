package com.example.spring_security_2;

import com.example.spring_security_2.entities.ApplicationUser;
import com.example.spring_security_2.entities.Role;
import com.example.spring_security_2.repository.RoleRepository;
import com.example.spring_security_2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}

	@Bean
	CommandLineRunner run (RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) {
				return;
			}

			Role AdminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(AdminRole);

			ApplicationUser admin = new ApplicationUser(null, "admin", passwordEncoder.encode("password"), roles);
			userRepository.save(admin);
		};
	}
}
