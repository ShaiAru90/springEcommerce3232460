package com.sena.springecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.springecommerce.model.Usuario;
import com.sena.springecommerce.service.IUsuarioService;

@RestController
@RequestMapping
public class APIUsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	// Endpoint GET para obtener todos los usuarios
	@GetMapping
	public List<Usuario> getAllUsuarios(){
		return usuarioService.findAll();
	}
	
	//Endpoint GET para obtener un usuario por ID
	@GetMapping("/user/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioService.get(id);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	//Endpoint POST para crear un nuevo producto
	@PostMapping("/create")
	public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
	 usuarioService.findById(1).get();
		usuario.setUsuario(u);
		if (usuario.getImagen() == null) {
			usuario.setImagen("default.jpg");
		}
		
	}
}
