package org.pk.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdemoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringdemoApplication.class);

	public static void main(String[] args) {
		LOG.debug("main method started");
		SpringApplication.run(SpringdemoApplication.class, args);
		LOG.debug("main method ended");
	}

}
