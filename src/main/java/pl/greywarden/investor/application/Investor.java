package pl.greywarden.investor.application;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static java.lang.String.format;

@CommonsLog
@SpringBootApplication
@ComponentScan(basePackages = "pl.greywarden.investor.*")
@EntityScan(basePackages = "pl.greywarden.investor.model")
@EnableJpaRepositories(basePackages = "pl.greywarden.investor.repository")
public class Investor {

    @Autowired
    private Environment environment;

    private static SpringApplication springApplication = new SpringApplication(Investor.class);

    public static void main(String... args) {
        springApplication.run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printApplicationStatus() {
        String applicationName = environment.getProperty("spring.application.name");
        String applicationPort = environment.getProperty("server.port");
        String activeProfiles = ArrayUtils.toString(environment.getActiveProfiles());

        log.info(format("Application %s started on port %s", applicationName, applicationPort));
        log.info("Profiles active: " + activeProfiles);
    }

}
