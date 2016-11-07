package ru.innopolis.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/studentsXLection/*").access("hasAnyRole('ROLE_ADMIN')")
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.formLogin()
			.loginProcessingUrl("/j_spring_security_check")
			.loginPage("/403")
			.defaultSuccessUrl("/login",true)
			.failureUrl("/login?error")
			.usernameParameter("j_username")
			.passwordParameter("j_password")
			.and()
			.logout().logoutSuccessUrl("/login?logout")
			.and()
			.csrf();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

}