package ru.innopolis.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

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
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select user_name as username,user_password as password, enabled from users where user_name=?")
			.authoritiesByUsernameQuery(
				"select t1.user_name as username, t3.role_name  as role " +
					"from users t1,users_cross_roles t2,roles t3 " +
					"where t1.id=t2.user_id and t2.role_id=t3.id and t1.user_name =?");
	}

}