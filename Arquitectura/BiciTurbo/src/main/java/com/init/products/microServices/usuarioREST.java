package com.init.products.microServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.products.dao.usuariosDAO;
import com.init.products.entitys.usuario;

@CrossOrigin(origins = "http://localhost:9070")
@RestController
@RequestMapping("user")
public class usuarioREST {

	
	/*
	 * Autowired inyecta las dependencias de la interfaz, es decir
	 * que cuando la aplicacion se ejecuta esta sera un objeto valido
	 * de products
	 */
	@Autowired
	private usuariosDAO usuariosDAO;
	
	@GetMapping
	public List <usuario> getAllUsers()
	{
		return usuariosDAO.findAll();
	}
	
	
	@RequestMapping(value = "{userId}") 
	public ResponseEntity<usuario> getUserById(@PathVariable("userId")  long userId)
	{
		Optional<usuario> optionalProduct = usuariosDAO.findById(userId);

		if(optionalProduct.isPresent())
		{
			return ResponseEntity.ok( optionalProduct.get() );
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	@PostMapping
	public ResponseEntity<usuario> createUser(@RequestBody usuario usuario)
	{
		usuario newProduct = usuariosDAO.save(usuario);
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value = "{usuarioId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("usuarioId")  Long usuarioId)
	{
		usuariosDAO.deleteById(usuarioId);
		return ResponseEntity.ok(null);
	}
	
	
	@PutMapping
	public ResponseEntity<usuario> updateUser(@RequestBody usuario usuario)
	{
		Optional<usuario> optionalProduct = usuariosDAO.findById(usuario.getId());

		if(optionalProduct.isPresent())
		{
			usuario updateProduct = optionalProduct.get();
			
			/*
			 * Set de todos los campos
			 */
			updateProduct.setNombre(usuario.getNombre());
			updateProduct.setCiudad(usuario.getCiudad());
			updateProduct.setTelefono(usuario.getTelefono());
			updateProduct.setEmail(usuario.getEmail());
			
			usuariosDAO.save(updateProduct);
			
			return ResponseEntity.ok(updateProduct);
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
