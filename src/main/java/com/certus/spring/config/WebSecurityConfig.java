package com.certus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        // Definir Usuario en memoria [JPA - Por alumnos J98 - calificado (P02)]

        @Bean
        InMemoryUserDetailsManager detailsManager() {

                User.UserBuilder usuarios = User.withDefaultPasswordEncoder();

                UserDetails UsuarioAdmin = usuarios
                                .username("Omar_EP")
                                .password("1234")
                                .roles("SuperAdmin")
                                .build();

                UserDetails Usuario1 = usuarios
                                .username("Pedro_CM")
                                .password("1234")
                                .roles("User")
                                .build();

                UserDetails Usuario2 = usuarios
                                .username("Estefany_HG")
                                .password("1234")
                                .roles("User")
                                .build();

                return new InMemoryUserDetailsManager(UsuarioAdmin, Usuario1, Usuario2);
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests((requests) -> requests
                                                .antMatchers("/app/home", "/bootstrap/**",
                                                                "/img/**", "/bootstrap/img/**",
                                                                "/app/adopcion", "/app/nosotros",
                                                                "/app/contacto", "/UploadsImg/**", "/crearusu",
                                                                "/app/crearusu", "/app/registro",
                                                                "/app/login", "/login?logout", "/app/login", "/login")
                                                .permitAll()
                                                .antMatchers("/app/crearreg", "/app/proximamente", "/app/login")
                                                .hasAnyRole("User", "SuperAdmin")
                                                .antMatchers("/app/Editarpets/**", "/app/Editarreg/**",
                                                                "/app/listarreg", "/Elimnarreg/**", "/Elimnar/**",
                                                                "/app/Editar/**", "/app/Editarreg/**",
                                                                "/app/listar", "/app/crear", "/app/form",
                                                                "/app/proximamente", "/app/login")
                                                .hasRole("SuperAdmin")
                                                .anyRequest().authenticated())
                                .formLogin(). // login configuration
                                loginPage("/login").usernameParameter("username")
                                .passwordParameter("password").defaultSuccessUrl("/app/home").permitAll();

                return http.build();
        }
        /*
         * @Bean
         * SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         * 
         * http.authorizeRequests(
         * (req) -> req
         * .antMatchers("/app/home", "/bootstrap/**", "/img/**").permitAll()
         * .antMatchers("/app/listar").hasAnyRole("User", "SuperAdmin")
         * .antMatchers("/app/Editar/**").hasRole("SuperAdmin")
         * .anyRequest().authenticated()
         * 
         * ).formLogin((form) -> form
         * .loginPage("/app/login")
         * .permitAll());
         * 
         * return http.build();
         * 
         * }
         * b
         */

}
