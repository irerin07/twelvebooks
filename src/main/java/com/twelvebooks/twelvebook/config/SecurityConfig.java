package com.twelvebooks.twelvebook.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/templates/**"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
                .requestMatchers(new AntPathRequestMatcher("/tmp/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll().and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/email").permitAll()
                .antMatchers(HttpMethod.GET, "/api/challenge/**").permitAll()
                .antMatchers("/api/**").hasRole("USER")
                .antMatchers("/users/delete").permitAll()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")


                .antMatchers("/notices/list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/notices/detail").hasAnyRole("USER", "ADMIN")
                .antMatchers("/notices/write").hasAnyRole("ADMIN")
                .antMatchers("/notices/modify").hasAnyRole("ADMIN")
                .antMatchers("/notices/delete").hasAnyRole("ADMIN")
                .antMatchers("/notices/modify/**").hasAnyRole("ADMIN")

                .antMatchers("/api/bookmark/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/bookmark/list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/bookmark/add").hasAnyRole("USER", "ADMIN")
                .antMatchers("/bookmark/delete").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/bookmark/delete").hasAnyRole("USER", "ADMIN")
                .antMatchers("/bookmark/delete/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/bookmark/delete/**").hasAnyRole("USER", "ADMIN")

                .antMatchers("/challenges/**").hasAnyRole("USER", "ADMIN")

                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/users/login")
                .loginPage("/users/login")
                .usernameParameter("email")
                .passwordParameter("passwd")
                .defaultSuccessUrl("/",true)
                .failureUrl("/users/login?fail=true");
    }
}
