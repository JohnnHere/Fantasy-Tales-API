package com.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L, "testenome", "urlfoto", "teste@teste.com", "teste123456"));
		usuarioRepository.save(new Usuario(0L, "testenome2", "urlfoto2", "teste2@teste.com", "teste1234564"));
		usuarioRepository.save(new Usuario(0L, "testenome3", "urlfoto3", "teste3@teste.com", "teste12345644"));
		usuarioRepository.save(new Usuario(0L, "testenome4", "urlfoto4", "teste4@teste.com", "teste123456444"));
		
		
	}
	
	@Test
	@DisplayName("Retorna um usuário")
	public void deveRetornarUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("teste@teste.com");
		assertTrue(usuario.get().getUsuario().equals("teste@teste.com"));
	}
	
}
