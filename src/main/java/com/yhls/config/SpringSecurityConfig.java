package com.yhls.config;

import com.yhls.filter.JwtAuthenticationFilter;
import com.yhls.security.CustomerUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter ;
    private final CustomerUserDetailsService customerUserDetailsService ;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    { http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .and()
            .authorizeHttpRequests(auth ->{
                auth.requestMatchers("/ufo/**").permitAll();
                auth.requestMatchers("/login").permitAll();
                auth.requestMatchers("/register").permitAll();
                auth.requestMatchers("/admin/**").hasAuthority("ADMIN");
                auth.requestMatchers("/superAdmin/**").hasAuthority("SUPERADMIN");
            })
            .httpBasic(Customizer.withDefaults());
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return  http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    { return authenticationConfiguration.getAuthenticationManager();}

    @Bean
    public PasswordEncoder passwordEncoder()
    { return new BCryptPasswordEncoder(); }

}

