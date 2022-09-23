package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Class variables
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	/**
	 * We use the passwordEncoder for encrypting
	 * @param auth
	 * @throws Exceptions
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Bean for BCryptPasswordEncoder
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Authentication manager, that returns the bean from auth
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * We configure the following end-points for acces. Users can't acces all the end-points.
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {	
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, "/login", "/register").permitAll()
			.antMatchers(HttpMethod.DELETE, "/api/**").hasAnyAuthority("ADMIN", "USER")
			.antMatchers(HttpMethod.DELETE, "/api/candidates/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/candidatePositions/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/candidatePositions/**").hasAnyAuthority("ADMIN", "USER")
			.antMatchers(HttpMethod.PUT, "/api/candidateSkills/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/candidateSkills/**").hasAnyAuthority("ADMIN", "USER")
			.antMatchers(HttpMethod.POST, "/api/positions").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/positions/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/skills/**").hasAnyAuthority("ADMIN", "USER")
			.anyRequest().authenticated()
			.and().headers()
            // the headers you want here. This solved all my CORS problems! dddS
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "*"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials", "true"))
            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "*"))
            .and()
			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	/**
	 * Cors-mapping to grand access for the allowed methods
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    List<String> allowedOriginsUrl = new ArrayList<>();
	    allowedOriginsUrl.add("https://deploy-23-09-22.d3o4e5d59xwnf7.amplifyapp.com");
	    allowedOriginsUrl.add("https://deploy-23-09-22.d3o4e5d59xwnf7.amplifyapp.com");
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.setAllowedOrigins(allowedOriginsUrl);
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    return source;
	}
}