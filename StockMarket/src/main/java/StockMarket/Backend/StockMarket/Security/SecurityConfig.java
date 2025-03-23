package StockMarket.Backend.StockMarket.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection if needed
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/register").permitAll() // Allow access to /login and /register without authentication
                .requestMatchers("/stockmarket/**").authenticated() // Require authentication for stockmarket endpoints
                .anyRequest().authenticated() // Require authentication for other requests
            )
            .formLogin(form -> form
                .loginPage("/login") // Specify the login page
                .defaultSuccessUrl("/home", true) // Redirect to /home after successful login
                .permitAll() // Allow access to the login page for everyone
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // Specify the logout URL
                .logoutSuccessUrl("/login?logout") // Redirect to login page with logout parameter on successful logout
                .permitAll() // Allow access to the logout URL for everyone
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory user details manager for testing purposes
        UserDetails user = User.withUsername("user")
                               .password(passwordEncoder().encode("password"))
                               .roles("USER")
                               .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
