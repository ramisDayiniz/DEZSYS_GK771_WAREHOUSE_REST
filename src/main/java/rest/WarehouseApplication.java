package rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import rest.model.WarehouseData;
import rest.warehouse.WarehouseController;
import rest.warehouse.WarehouseService;

@SpringBootApplication
public class WarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	@Bean
	@Profile("!test")
	public CommandLineRunner run(WarehouseService service) {
		return args -> {
			WarehouseData data = service.getWarehouseData("001");
			System.out.println("Warehouse Name: " + data.getWarehouseName());
			data.getProducts().forEach(p ->
					System.out.println(p.getProductName() + " - " + p.getProductQuantity())
			);
		};
	}



}
