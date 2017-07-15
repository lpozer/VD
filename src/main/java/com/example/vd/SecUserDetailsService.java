package com.example.vd;

import com.example.vd.user.User;
import com.example.vd.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by leandropozer on 10/07/17.
 */
@Component
public class SecUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }else{
            UserDetails details = new SecUserDetails(user.getUserName(), user.getPassword(), user.getAuthorities().toArray(new String[1]));
            return details;
        }
    }
}
