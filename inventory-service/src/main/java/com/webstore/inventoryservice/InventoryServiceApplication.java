package com.webstore.inventoryservice;

import com.webstore.inventoryservice.Entity.Inventory;
import com.webstore.inventoryservice.Repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.webstore.inventoryservice")
@EnableJpaRepositories("com.webstore.inventoryservice.*")
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args); }

		// Once the code is run, it updates the databases, so a query to reach the inventory and check whether the product is in stock is possible

		@Bean
		public CommandLineRunner loadData(InventoryRepository inventoryRepository){

			return args -> {
				Inventory fakeProduct = new Inventory();
				fakeProduct.setProductNumber("4");
				fakeProduct.setProductTile("T-shift premium");
				fakeProduct.setQuantity(10);

				inventoryRepository.save(fakeProduct);
			};
		}
}