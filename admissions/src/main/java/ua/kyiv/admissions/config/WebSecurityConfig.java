package ua.kyiv.admissions.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	public WebSecurityConfig(UserDetailsService userDetailsService, AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.userDetailsService = userDetailsService;
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/", "/css/**", "/vendor/**", "/registration").permitAll()
			.antMatchers("/home", "/registrationEntrant").access("hasRole('ROLE_USER')")
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("email").passwordParameter("password")
			.successHandler(authenticationSuccessHandler)
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/login?logout")
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/403")
			.and().csrf();
	}
}
