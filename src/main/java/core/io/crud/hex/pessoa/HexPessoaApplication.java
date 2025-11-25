package core.io.crud.hex.pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "core.io.crud.hex.pessoa.adapters.out.client")
public class HexPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexPessoaApplication.class, args);
	}

}
