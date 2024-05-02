//package br.com.leadersofts.qikserve.infrastructure.configuration;
//
//import br.com.leadersofts.qikserve.infrastructure.security.service.SecurityFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Autowired
//    private SecurityFilter securityFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .cors(Customizer.withDefaults())
//                .sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
////                .authorizeHttpRequests(authorize -> authorize
//
////                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
////                        .requestMatchers(HttpMethod.POST, "/auth/create").permitAll()
////                        .requestMatchers(HttpMethod.POST,"/lead/**").permitAll()
////                        .requestMatchers(HttpMethod.POST,"/localizacao/**").permitAll()
////                        .requestMatchers(HttpMethod.POST,"/leads/**").permitAll()
////
////                        .requestMatchers(HttpMethod.GET,"/lead/**").permitAll()
////                        .requestMatchers(HttpMethod.GET,"/localizacao/**").permitAll()
////                        .requestMatchers(HttpMethod.GET,"/leads/**").permitAll()
////
////                        .requestMatchers(HttpMethod.DELETE,"/lead/**").permitAll()
////                        .requestMatchers(HttpMethod.DELETE,"/localizacao/**").permitAll()
////                        .requestMatchers(HttpMethod.DELETE,"/leads/**").permitAll()
////
////                        .requestMatchers(HttpMethod.PUT,"/lead/**").permitAll()
////                        .requestMatchers(HttpMethod.PUT,"/localizacao/**").permitAll()
////                        .requestMatchers(HttpMethod.PUT,"/leads/**").permitAll()
////
////                        .requestMatchers(HttpMethod.PATCH,"/lead/**").permitAll()
////                        .requestMatchers(HttpMethod.PATCH,"/localizacao/**").permitAll()
////                        .requestMatchers(HttpMethod.PATCH,"/leads/**").permitAll()
//
////                        .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
////                        .requestMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll()
////
////                        .anyRequest().authenticated()
////                )
//
////                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
////                .build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfiguration() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
//                        .allowCredentials(false);
//            }
//        };
//    }
//
//}
