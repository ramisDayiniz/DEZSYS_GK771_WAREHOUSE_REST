package rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import rest.model.WarehouseData;
import rest.warehouse.WarehouseService;
/**
 * Hauptklasse der Spring Boot-Anwendung für das Warehouse-System.
 * Startet die Anwendung, konfiguriert einen RestTemplate-Client und führt optional beim
 * Anwendungsstart ein Beispiel aus, um Lagerdaten im Konsolen-Log anzuzeigen.
 *
 * Rolle im System: Einstiegspunkt der Spring Boot-Anwendung, stellt Beans bereit
 * und initialisiert Test- oder Beispielausgaben.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
@SpringBootApplication
public class WarehouseApplication {

	/**
	 * Einstiegspunkt der Anwendung.
	 *
	 * @param args Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	/**
	 * Bean für RestTemplate zur Nutzung von REST-Aufrufen innerhalb der Anwendung.
	 *
	 * @param builder RestTemplateBuilder zur Konfiguration des Clients
	 * @return konfiguriertes RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	/**
	 * CommandLineRunner-Bean, die beim Start der Anwendung ausgeführt wird.
	 * Gibt Beispiel-Lagerdaten der ID "001" in der Konsole aus.
	 * Wird nur ausgeführt, wenn das Profil nicht "test" aktiv ist.
	 *
	 * @param service WarehouseService zur Abfrage von Lagerdaten
	 * @return CommandLineRunner-Instanz
	 */
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
