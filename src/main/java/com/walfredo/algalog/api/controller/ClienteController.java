package com.walfredo.algalog.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfredo.algalog.domain.model.Cliente;
import com.walfredo.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes") 
public class ClienteController {		
	
	private ClienteRepository cr;
	
	@GetMapping
	public List<Cliente> listar() {
		return cr.findAll();
	}
	
	@GetMapping("/clientesbynome")
	public List<Cliente> listarby(String nome) {
		return cr.findByNomeContaining(nome);
	}
	
	@GetMapping ("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return cr.findById(clienteId)
//			.map(cliente -> ResponseEntity.ok(cliente))
			.map(ResponseEntity::ok)
			.orElse (ResponseEntity.notFound().build());		
//		Optional<Cliente> cliente =  cr.findById(clienteId);
//		if (cliente.isPresent()) {
//	/		return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return cr.save(cliente);
	};
	
	@PutMapping("{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,@RequestBody Cliente cliente){
		if (!cr.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);		
		cr.save(cliente);
		return ResponseEntity.ok(cliente);		
	};
	
	@DeleteMapping("{clienteId}")
	public ResponseEntity<Void> deletar( @PathVariable Long clienteId){
		if (!cr.existsById(clienteId)) 
			return ResponseEntity.notFound().build();
		cr.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}

}
