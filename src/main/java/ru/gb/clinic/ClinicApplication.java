package ru.gb.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicApplication {

	/*@Autowired
	ProductService productService;

	@Autowired
	ClientService clientService;*/

	public static void main(String[] args) {
		SpringApplication.run(ClinicApplication.class, args);
	}

	/*@Bean
	public void generateProducts() {
		Random random = new Random();
		Client client = new Client();
		client.setFirstName("Имя");
		client.setLastName("Фамилия");
		Client savedClient = clientService.saveClient(client);
		List<Product> productList = new ArrayList<Product>(20);
		for (int i = 0; i < 20; i++) {
			Product product = new Product();
			product.setTitle("Продукт " + i);
			product.setCost(random.nextInt(100));
			product.setPuchaseDate(Date.valueOf(LocalDate.now()));
			product.setClient(savedClient);
			productService.saveOrUpdate(product);
			productList.add(product);
		}
		savedClient.setProducts(productList);
		System.out.println("Выполнено создание сущностей в СУБД");
	}*/
}
