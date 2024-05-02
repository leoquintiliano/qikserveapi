package br.com.leadersofts.qikserve;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(value = "br.com.leadersofts.beachstuffrental")
@EnableJpaRepositories(basePackages = "br.com.leadersofts.qikserve")
public class BeachstuffrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeachstuffrentalApplication.class, args);
	}

	@PostConstruct
	public void initBeforeApplicationStarts() {
		LoggerFactory.getLogger("BeachStuffRentalApplication").info("Loading scripts...");
	}

}
