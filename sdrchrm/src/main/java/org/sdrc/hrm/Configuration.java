/**
 * 
 */
package org.sdrc.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@SpringBootApplication
@EntityScan(basePackages="org.sdrc.hrm.domain")
@EnableJpaRepositories({"org.sdrc.hrm.repository.springdata"})
@EnableTransactionManagement
@EnableWebMvc
public class Configuration  extends  SpringBootServletInitializer{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);

	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Configuration.class);
	    }
	
	// will uncomment while implementing security
	 
	@Bean
	public MessageDigestPasswordEncoder passwordEncoder() {
		return new MessageDigestPasswordEncoder("sha-256");
	}
	
}
