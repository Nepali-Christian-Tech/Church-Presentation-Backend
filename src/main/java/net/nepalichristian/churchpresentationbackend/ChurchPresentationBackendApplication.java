package net.nepalichristian.churchpresentationbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChurchPresentationBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChurchPresentationBackendApplication.class, args);
  }

}
