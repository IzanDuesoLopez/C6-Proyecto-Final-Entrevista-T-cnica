package com.example.demo.security;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

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
	 * @throws Exception
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
		httpSecurity.csrf().disable()
				// We authorize for everyone /login and /register end-points
				.authorizeRequests().antMatchers("/login", "/register").permitAll()
				// We grant acces to the following users and the following end-points
				.antMatchers(HttpMethod.DELETE, "/api/**").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/api/candidatePositions/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/candidatePositions/**").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/api/candidateSkills/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/candidateSkills/**").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.POST, "/api/positions").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/positions/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/skills/**").hasAnyAuthority("ADMIN", "USER")
				.anyRequest().authenticated().and().
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// We add a filter to validate every request with the jwt
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	/**
	 * Cors-mapping to grand access for the allowed methods
	 */
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/api/**")
		 .allowedMethods("*")
		 .allowedHeaders("*")
		 .exposedHeaders("*");

	    }

}