package changwonNationalUniv.soCool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SoCoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoCoolApplication.class, args);
	}

}
