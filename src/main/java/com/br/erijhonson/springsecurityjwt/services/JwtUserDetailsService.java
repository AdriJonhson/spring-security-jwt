package com.br.erijhonson.springsecurityjwt.services;

import com.br.erijhonson.springsecurityjwt.data.dtos.UserDTO;
import com.br.erijhonson.springsecurityjwt.models.UserProfile;
import com.br.erijhonson.springsecurityjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public UserProfile save(UserDTO user) {
        UserProfile newUser = UserProfile.builder()
                .username(user.getUsername())
                .password(bcryptEncoder.encode(user.getPassword()))
                .build();

        return userDao.save(newUser);
    }
}
