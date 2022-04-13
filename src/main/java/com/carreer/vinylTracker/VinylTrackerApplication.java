package com.carreer.vinylTracker;

import com.carreer.vinylTracker.models.auth.ERole;
import com.carreer.vinylTracker.repositories.RoleRepository;
import com.carreer.vinylTracker.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication
public class VinylTrackerApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	@Value("${spring.datasource.driver-class-name}")
	private String myDriver;

	@Value("${spring.datasource.url}")
	private String myUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
	public static void main(String[] args) {
		SpringApplication.run(VinylTrackerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		int roleCheck = roleRepository.isRoleEmpty();

		if (roleCheck < ERole.values().length) {
			int id = 1;
			for (ERole role : ERole.values()) {
				if (roleRepository.findByName(role).isEmpty()) {
					try {
						Connection conn = DriverManager.getConnection(myUrl, username, password);
						Class.forName(myDriver);
						String query = "Insert into role (id, name) values (?,?)";
						PreparedStatement statement = conn.prepareStatement(query);

						statement.setString(1, Integer.toString(id));
						statement.setString(2, role.toString());

						statement.executeUpdate();

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				id++;
			}
		}
		return builder.build();
	}

}

//Application checklist:
/*Bonus entity
	TODO - Create Content entity
*/
/*Features:
	TODO - can register a user account
	TODO - can log in with existing user account
	TODO - can create a profile with valid authentication
	TODO - can pull profiles with valid authentication
*/
/*Bonus features:
	TODO - can create a content with valid authentication
	TODO - can pull content with valid authentication
	TODO - create one custom query for the content entities repository.
*/

