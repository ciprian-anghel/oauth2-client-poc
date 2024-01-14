package com.mizu.mizucore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	//generate values: GitHub > profile > settings > developer settings > Oauth apps
	private static final String CLIENT_ID = "";
	private static final String CLIENT_SECRET = "";
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(
					authorize -> authorize
						.anyRequest().authenticated())
			.oauth2Login(Customizer.withDefaults());
		return http.build();
	}
	
	/*
	 * This can be replaced with configuration settings:
	 * spring.security.oauth2.client.registration.github.client-id
	 * spring.security.oauth2.client.registration.github.client-secret
	*/
	@Bean
	public ClientRegistrationRepository clientRepository() {
		ClientRegistration clientReg = getClientRegistration();
		return new InMemoryClientRegistrationRepository(clientReg);
	}
	
	private ClientRegistration getClientRegistration() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github")
				.clientId(CLIENT_ID)
				.clientSecret(CLIENT_SECRET)
				.build();
	}
	
}
