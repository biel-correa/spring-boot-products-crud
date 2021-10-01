package br.dev.correa.springbootproductscrud.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args ->{
            Product teclado = new Product(
                    "Teclado Multilazer",
                    (float) 25.90
            );

            Product mouse = new Product(
                    "Mouse Microsoft",
                    (float) 15.90
            );

            repository.saveAll(List.of(teclado, mouse));
        };
    }
}
