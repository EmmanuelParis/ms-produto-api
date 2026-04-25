package br.com.faculdadecatolicapb.ms_produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsProdutoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsProdutoApplication.class, args);
	}
}