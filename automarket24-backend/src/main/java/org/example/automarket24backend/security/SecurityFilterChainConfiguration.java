package org.example.automarket24backend.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@AllArgsConstructor
public class SecurityFilterChainConfiguration {

    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private CorsConfigurationSource corsConfigurationSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/swagger-ui/**", "/api-docs/**", "/v2/api-docs",
                                        "/configuration/ui", "/swagger-resources/**", "/api-docs-ui.html",
                                        "/configuration/security", "/swagger-ui.html", "/webjars/**",
                                        "/v3/api-docs/**")
                                .permitAll()
                                .requestMatchers(HttpMethod.GET,
                                        "/features", "/colors", "/fuel-types", "/generations",
                                        "/transmissions", "/drivetrains", "/models", "/makes",
                                        "/offers/**", "/body-types", "/conditions", "/users/**"
                                ).permitAll()
                                .requestMatchers("/login", "/register").permitAll()
                                .requestMatchers(HttpMethod.DELETE,"/offers/**").hasAnyAuthority("Admin", "Private")
                                .requestMatchers(HttpMethod.POST,"/offers/**").hasAnyAuthority("Admin", "Private")
                                .requestMatchers("/users/**").hasAuthority("Admin")
                                .anyRequest().authenticated()
                ).exceptionHandling(exception -> exception
                        .accessDeniedHandler(new JwtAccessDeniedHandler())
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .sessionManagement(
                        session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
