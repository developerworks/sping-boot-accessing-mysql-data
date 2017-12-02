package cn.totorotec.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

@Configuration
//@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig {

    // extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

//    @Autowired
//    private UserDetailsService userDetailsService;

//    @Autowired
//    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        logger.info("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
//        super.configure(http);
//        http
//            .authorizeRequests()
//            .antMatchers("/", "/home").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .and()
//            .httpBasic();
//        http
//            .authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .and()
//            .httpBasic().disable();
//        http
//            .sessionManagement()
//            .invalidSessionUrl("/invalidSessionUrl")
//            .maximumSessions(1);
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
//        auth.inMemoryAuthentication()
//            .withUser("user").password("password").roles("USER").and()
//            .withUser("admin").password("password").roles("ADMIN");
//    }
}
