package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class ProjectSecurityConfig {
	@Bean
	public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
	
	
		http.authorizeHttpRequests( (auth)->auth
				.antMatchers("/masai/employee/profile","/masai/welcomeP").authenticated()
				.antMatchers("/masai/admin").hasRole("ADMIN")
				.antMatchers("/masai/employee/register","/masai/welcome").permitAll()
				
		).csrf().disable()
		.httpBasic();
	
		return http.build();
}

	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }

}









//@Configuration
//public class ProjectSecurityConfig {
//
//    @Bean
//   SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests((auth) -> auth
//                        .requestMatchers("/masai/welcomeP").authenticated()
//                        .requestMatchers("/masai/welcome").permitAll()
//        ).httpBasic();
//
//        return http.build();
//    }
    
//    @Bean
//	public InMemoryUserDetailsManager userDetails() {
//	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//	  UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
//	    UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//	    userDetailsService.createUser(admin);
//	    userDetailsService.createUser(user);
//	    return userDetailsService;
//	}

//	 @Bean
//	 public PasswordEncoder passwordEncoder() {
//	        return NoOpPasswordEncoder.getInstance();
//	 }
//
// 
//}
