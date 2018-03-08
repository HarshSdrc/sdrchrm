/**
 * 
 */
package org.sdrc.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

	
/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@Configuration
@EnableWebSecurity(debug=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private  UserAuthenticationProvider userAuthenticationProvider;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**", "/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().defaultSuccessUrl("/home").loginPage("/login")
                    .and()
                .logout().logoutSuccessUrl("/login")
                    .permitAll().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        
    }
	
	  @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.authenticationProvider(userAuthenticationProvider);
	    }
}
