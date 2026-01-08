package br.com.gdev.invoicemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(Customizer.withDefaults()).httpBasic(Customizer.withDefaults())
				.formLogin(form -> form.loginPage("/sign-in").failureUrl("/sign-in?error=true").loginProcessingUrl("/perform_login")
						.defaultSuccessUrl("/sign-in/home", true).permitAll())
				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/sign-in/register", "/css/**").permitAll().anyRequest().authenticated());

		return http.build();
	}

}
