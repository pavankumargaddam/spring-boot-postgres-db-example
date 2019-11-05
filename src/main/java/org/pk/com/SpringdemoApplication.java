package org.pk.com;

import org.pk.com.audit.AuditorAwareImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringdemoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringdemoApplication.class);

	public static void main(String[] args) {
		LOG.debug("main method started");
		SpringApplication.run(SpringdemoApplication.class, args);
		LOG.debug("main method ended");
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

}
