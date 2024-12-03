package br.com.jards.screematch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jards.model.DadosSerie;
import br.com.jards.service.ConsumoApi;
import br.com.jards.service.ConverteDados;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

	private static final String API_KEY = "&apikey=936f23f1";

	public static void main(String[] args) {
		SpringApplication.run(ScreematchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls" + API_KEY);
		System.out.println(json);

		// json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		// System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.oberDados(json, DadosSerie.class);
		System.out.println(dados);
	}

}
