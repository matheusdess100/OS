package com.valdir.os;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valdir.os.domain.Cliente;
import com.valdir.os.domain.OS;
import com.valdir.os.domain.Tecnico;
import com.valdir.os.domain.enuns.Prioridade;
import com.valdir.os.domain.enuns.Status;
import com.valdir.os.repositories.ClienteRepository;
import com.valdir.os.repositories.OSRepository;
import com.valdir.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Valdir machado", "132.524.237-80", "(21) 9427-3823");
		Cliente c1 = new Cliente(null, "Betina Cruz", "134.514.227-80", "(21) 9437-3523");
		OS os1 = new OS(null, Prioridade.ALTA, "teste criate od", Status.ANDAMENTO, t1, c1);

		
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
