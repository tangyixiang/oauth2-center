package com.sky.oauth2.service.impl;

import com.sky.oauth2.model.UserInfo;
import com.sky.oauth2.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Qualifier("userService")
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = userClient.findByUserIdentifier(s);
        return new User(userInfo.getIdentifier(),passwordEncoder.encode(userInfo.getPassword()),new HashSet<GrantedAuthority>());
    }


}
