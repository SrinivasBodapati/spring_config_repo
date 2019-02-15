package com.boa.kyc.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;


@Configuration
@EnableWebSecurity
public class BOAWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService getInstance() {
		return new BOACustomerVerification();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub		
		auth.userDetailsService(getInstance()).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        
	          .authorizeRequests()          
	          .anyRequest()
	          .authenticated()
	          .and()
	          .httpBasic();
	        http.authorizeRequests()
	        .accessDecisionManager(accessDecisionManager());        // passed custom access decision manager
	    }
	 @Bean
	    public AccessDecisionManager accessDecisionManager() {
	    	 List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<AccessDecisionVoter<? extends Object>>();
	    	 decisionVoters.add(new WebExpressionVoter());
	    	 decisionVoters.add( new AuthenticatedVoter());
	    	 //decisionVoters.add(new WebExpressionVoter());
	    	 decisionVoters.add( new WeekOffVoter() );
	    	
	        return new UnanimousBased(decisionVoters);
	    }

}
