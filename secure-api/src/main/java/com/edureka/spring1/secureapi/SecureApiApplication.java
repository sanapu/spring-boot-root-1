package com.edureka.spring1.secureapi;


import com.edureka.spring1.secureapi.model.UserAccount;
import com.edureka.spring1.secureapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.*;
import java.util.stream.Stream;

//import org.springframework.security.core.GrantedAuthority;

@SpringBootApplication
public class SecureApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        UserAccount.builder().username("user1")
//                .password("1234")
//                .active(true)
//                .build();

//        userRepository.save(UserAccount.builder().username("user1")
//                .password("1234")
//                .active(true)
//                .build());

//
        return args -> Stream.of("User1,pass1", "User2,pass2")
                .map(s -> s.split(","))
                .forEach(strings -> userRepository.save(new UserAccount(strings[0], strings[1], true)));
    }

    @Bean
   public static NoOpPasswordEncoder noOpPasswordEncoder(){
        return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }

    @Service
    public class UserService implements UserDetailsService {


        @Autowired
        UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // get the user account information for the username  call

            Optional<UserAccount> byUsername1 = userRepository.findByUsername(username);
// getauthorities() is the key here
            final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("User"));
          //  return authorities;
            // map the user account details from database to the actual user call and authorize using UserDetailsservice
            User user = byUsername1
                    .map(userAccount ->
                         new User(userAccount.getUsername(), userAccount.getPassword(), userAccount.isActive(), true, true, true,
                                 authorities))
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

//            UserAccount byUsername = userRepository.findUserByUsername(username);
//            if (byUsername == null) {
//                throw new UsernameNotFoundException(username);
//            }
//            return new UserPrincipal(byUsername);
            return user;


        }

    }


}
