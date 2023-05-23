package com.walfredo.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walfredo.algalog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var  cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("joao");
		cliente1.setTelefone("33 99999-6699");
		cliente1.setEmail("joao@email.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("pedro");
		cliente2.setTelefone("33 99999-6699");
		cliente2.setEmail("pedro@email.com");
		
		
		return Arrays.asList(cliente1,cliente2);
		
	}

}
