package dev.naimsulejmani.gr3fakenews.config;

import dev.naimsulejmani.gr3fakenews.repositories.DataInitializer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // const appConfig = new AppConfig();
    // ApplicationRunner applicationRunner = appConfig.applicationRunner(new DataInitializer());

    @Bean
    public ApplicationRunner applicationRunner(DataInitializer dataInitializer) {
        return args -> dataInitializer.run();
    }
}
