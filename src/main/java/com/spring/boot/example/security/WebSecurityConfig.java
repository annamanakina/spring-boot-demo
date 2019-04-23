package com.spring.boot.example.security;

import com.spring.boot.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;
    //todo get user from db
    //replace it to UserService
    //and get data from this service
    //https://www.youtube.com/watch?v=WDlifgLS8iQ
    //https://www.youtube.com/watch?v=AdLXmE4rjy4
    //https://www.youtube.com/watch?v=dVTh--j1suI&list=PLsyeobzWxl7oA8QOlMtQsRT_I7Rx2hoX4&index=12
//https://devcolibri.com/быстрый-страт-в-spring-security/
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //for main page full access
                    .antMatchers( "/", "/main", "/register", "/css/**").permitAll()
                    //for any other authentication is required
                    .anyRequest() //allow all urls
                    .authenticated() //all URLs are allowed by any authenticated user, no role restrictions.
                .and()
                .formLogin()
                //login page is on this mapping
                    .loginPage("/login")
                .defaultSuccessUrl("/main")
                .failureUrl("/login?error")
                //allow to use it for all
                .permitAll()
                .and()
                //enable logout and allow to use it for all
                    .logout()
                    .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //todo https://www.baeldung.com/spring-security-authentication-with-a-database
       // userRepository.findUserByEmail()

        // todo get data from this service
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("\n" +
                                "jhbjh@email.com")
                        .password("123123")
                        .roles("USER")
                        .build();
        System.out.println("UserDetailsService: "+user);
        System.out.println("UserDetailsService: "+user.toString());
        return new InMemoryUserDetailsManager(user);
    }*/
}
