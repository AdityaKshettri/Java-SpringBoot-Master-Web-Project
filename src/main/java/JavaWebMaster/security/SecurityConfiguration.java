package JavaWebMaster.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import JavaWebMaster.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception 
	{
		httpSecurity
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/h2-console").permitAll()//for h2-console
				.antMatchers("/user/signup").permitAll()
				.and()
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/user/login")
				.defaultSuccessUrl("/basic/list")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/error");
		
		httpSecurity.csrf().disable();//for h2-console
        httpSecurity.headers().frameOptions().disable();//for h2-console
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, SpringDataUserDetailsService springDataUserDetailsService) throws Exception 
	{
		auth.userDetailsService(springDataUserDetailsService);
	}
}
