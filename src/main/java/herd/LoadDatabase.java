package herd;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CowRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Cow(123,  (long) 44321, "Active")));
            log.info("Preloading " + repository.save(new Cow(456,(long) 54232,"Broken")));
        };
    }
}