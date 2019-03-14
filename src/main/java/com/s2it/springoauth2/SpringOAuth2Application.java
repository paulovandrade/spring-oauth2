package com.s2it.springoauth2;

import com.s2it.springoauth2.model.RoleEnum;
import com.s2it.springoauth2.model.UserEntity;
import com.s2it.springoauth2.repository.UserRepository;
import com.s2it.springoauth2.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOAuth2Application {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringOAuth2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			UserEntity estag = new UserEntity();
			estag.setEmail("estagiario@s2it.com.br");
			estag.setRole(RoleEnum.ROLE_USER);
			estag.setPassword(PasswordUtils.generateBCrypt("123456"));
			this.userRepository.save(estag);

			UserEntity dev = new UserEntity();
			dev.setEmail("dev@s2it.com.br");
			dev.setRole(RoleEnum.ROLE_ADMIN);
			dev.setPassword(PasswordUtils.generateBCrypt("123456"));
			this.userRepository.save(dev);

		};
	}
}
