package app;

import app.core.Burger;
import app.core.BurgerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class StartBurgerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(StartBurgerApplication.class, args);
    }

    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BurgerRepository burgerRepository) {
        return args -> {
            burgerRepository.save(new Burger("húsimádó", false, Integer.MAX_VALUE, 727 ));
            burgerRepository.save(new Burger("MushroomTower", false, 3, 1945 ));
            burgerRepository.save(new Burger("Vándorzenész burger", true, 0, 900));
        };
    }
}
