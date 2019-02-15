package com.boa.kyc.configurations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BOACustomerVerification implements UserDetailsService {
	
	 private static List<BOAUser> users = new ArrayList();

	    public BOACustomerVerification() {
	        //in a real application, instead of using local data,
	        // we will find user details by some other means e.g. from an external system
	        users.add(new BOAUser("user1", "123", "ADMIN"));
	        users.add(new BOAUser("user2", "234", "ADMIN"));
	        users.add(new BOAUser("user3", "234", "USER"));
	    }

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<BOAUser> user = users.stream().filter(u -> u.getUsername().equals(userName)).findFirst();
		
		if(user.isPresent())
			throw new UsernameNotFoundException("user name not found");
		else 
			return toUserDetails(user.get());
	}
	
	
	 private UserDetails toUserDetails(BOAUser userObject) {
	        return User.withUsername(userObject.getUsername())
	                   .password(userObject.getPassword())
	                   .roles(userObject.getRole()).build();
	    }
}
