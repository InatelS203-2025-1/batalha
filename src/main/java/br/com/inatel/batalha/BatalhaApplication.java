package br.com.inatel.batalha;

import br.com.inatel.batalha.controller.BatalhaController;
import br.com.inatel.batalha.menu.TerminalMenu;
import br.com.inatel.batalha.service.BatalhaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BatalhaApplication implements CommandLineRunner {

	private final ApplicationContext context;

	public BatalhaApplication(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args) {
		SpringApplication.run(BatalhaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		BatalhaService service = context.getBean(BatalhaService.class);
		TerminalMenu menu = new TerminalMenu(service);
		menu.exibirMenu();
	}
}