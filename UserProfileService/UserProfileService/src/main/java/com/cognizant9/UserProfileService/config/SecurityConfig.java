/**
 * 
 */
package com.cognizant9.UserProfileService.config;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author mohit
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	   @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.cors();
	        httpSecurity.csrf().disable()
	                .authorizeRequests().antMatchers("/api/v1/users/register", "/api/v1/**").permitAll()
	                .antMatchers(HttpHeaders.ALLOW).permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        ;

	       // httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

