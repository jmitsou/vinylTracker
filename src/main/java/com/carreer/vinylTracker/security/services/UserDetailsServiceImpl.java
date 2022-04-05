package com.carreer.vinylTracker.security.services;

import com.carreer.vinylTracker.models.auth.User;
import com.carreer.vinylTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not" +
                " Found: " + username));
        return user;
    }
}
