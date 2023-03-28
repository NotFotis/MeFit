package com.example.mefit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Enable CORS -- this is further configured on the controllers
                //.cors().and()
                // Sessions will not be used
                //.sessionManagement().disable()
                // Disable CSRF -- not necessary when there are no sessions
                //.csrf().disable()
                // Enable security for http requests
                .authorizeHttpRequests(authorize -> authorize
                     // FOR EXERCISES
                        //.requestMatchers(HttpMethod.GET,"/api/v1/exercise").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/exercise/*").hasAnyRole("Admin","Contributor","User")              
                        //.requestMatchers(HttpMethod.POST,"/api/v1/exercise").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.PATCH,"/api/v1/exercise/*").hasAnyRole("Admin","Contributor")               
                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/exercise/*").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/exercise/*/workout").hasAnyRole("Admin","Contributor","User")    
                                                 
                        // FOR WORKOUTS
                        //.requestMatchers(HttpMethod.GET,"/api/v1/workout").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/workout/*").hasAnyRole("Admin","Contributor","User")              
                        //.requestMatchers(HttpMethod.POST,"/api/v1/workout").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.PATCH,"/api/v1/workout/*").hasAnyRole("Admin","Contributor")               
                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/workout/*").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/workout/*/exercise").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/workout/*/program").hasAnyRole("Admin","Contributor","User")               
                                       
                        // FOR PROGRAMS
                        //.requestMatchers(HttpMethod.GET,"/api/v1/program").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/program/*").hasAnyRole("Admin","Contributor","User")              
                        //.requestMatchers(HttpMethod.POST,"/api/v1/program").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.PATCH,"/api/v1/program/*").hasAnyRole("Admin","Contributor")               
                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/program/*").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/program/*/workout").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/program/*/goal").hasAnyRole("Admin","Contributor","User")               
                                       
                        // FOR GOALS
                        //.requestMatchers(HttpMethod.GET,"/api/v1/goal").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/goal/*").hasAnyRole("Admin","Contributor","User")              
                        //.requestMatchers(HttpMethod.POST,"/api/v1/goal").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.PATCH,"/api/v1/goal/*").hasAnyRole("Admin","Contributor")               
                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/goal/*").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/goal/*/program").hasAnyRole("Admin","Contributor","User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/goal/*/profile").hasAnyRole("Admin","Contributor")
                                                  
                        // FOR PROFILES
                        //.requestMatchers(HttpMethod.GET,"/api/v1/profile").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/profile/*").hasAnyRole("Admin","Contributor")
                        //.requestMatchers(HttpMethod.PATCH,"/api/v1/profile/*").hasAnyRole("Admin")
                        //.requestMatchers(HttpMethod.POST,"/api/v1/profile").hasAnyRole("Admin")
                        
                                       ///////////////EDW THELEI FTIACHSIMO///////////////
                        //.requestMatchers(HttpMethod.GET,"/api/v1/profile/profile_id").hasAnyRole("User")
                        //.requestMatchers(HttpMethod.PATCH,"/api/v1/profile/profile_id").hasAnyRole("User")
                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/profile/profile_id").hasAnyRole("User")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/profile/profile_id/goal").hasAnyRole("User")
                                       ///////////////MEXRI EDW///////////////
                                                     
                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/profile/*").hasAnyRole("Admin")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/profile/*/goal").hasAnyRole("Admin")
                                              
                        // FOR USERS
                        //.requestMatchers(HttpMethod.GET,"/api/v1/users").hasAnyRole("Admin")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/users/info").hasAnyRole("Admin")               
                        //.requestMatchers(HttpMethod.GET,"/api/v1/users/principal").hasAnyRole("Admin")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/users/current").hasAnyRole("Admin")
                        //.requestMatchers(HttpMethod.GET,"/api/v1/users/register").hasAnyRole("Admin")
                     .requestMatchers("/api/v1/exercise").permitAll()
                        .requestMatchers("/api/v1/profile").permitAll()
                        .requestMatchers("/api/v1/workout").permitAll()
                        .requestMatchers("/api/v1/goal").permitAll()
                        .requestMatchers("/api/v1/program").permitAll()
                        .requestMatchers("api/v1/users/info").hasRole("profile")
                        .requestMatchers("api/v1/users/principal").hasAuthority("profile")
                        // All remaining paths require authentication
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverterForKeycloak());
        return http.build();
    }

    @SuppressWarnings("unused")
    public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
            Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
            Collection<String> roles = realmAccess.get("roles");
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        };

        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

        return jwtAuthenticationConverter;
    }
}

