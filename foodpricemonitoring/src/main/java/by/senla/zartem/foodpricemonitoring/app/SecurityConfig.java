package by.senla.zartem.foodpricemonitoring.app;

import java.util.EnumSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    PasswordEncoder passwordEncoder;
 
	private DataSource dataSource() {
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource(
						"jdbc:postgresql://localhost:5432/FoodPriceMonitoring",
						"postgres",
						"123qwe");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		  auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder)
		  .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
		  .and()
		  .withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
		  
		  SecurityContextHolder contextHolder =  new SecurityContextHolder();
		  
//		  UserDetailsService
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.jdbcAuthentication() .dataSource(dataSource()) .withDefaultSchema()
		 * .withUser(users.username("user").password("password").roles("USER"))
		 * .withUser(users.username("admin").password("password").roles("USER","ADMIN"))
		 * ;
		 */
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/**").hasAnyRole("ADMIN", "USER")
        .and().formLogin()
        .and().logout().logoutSuccessUrl("/login").permitAll()
        .and().csrf().disable();
    }
}
