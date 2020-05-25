package com.init.products.rest;

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

import com.init.products.dao.ProductsDAO;
import com.init.products.entitys.Product;

/*
 * RestController esto nos permite decir que se va a comportar
 * esta clase como una API REST
 * 
 * RequestMapping: Le indicamos la URI de nuestro Microservicio,
 * es decir, este que tenemos en esta clase
 */
@RestController
@RequestMapping("products")
public class ProductsREST {

	/*
	 * Autowired inyecta las dependencias de la interfaz, es decir
	 * que cuando la aplicacion se ejecuta esta sera un objeto valido
	 * de products
	 */
	@Autowired
	private ProductsDAO productDAO;

	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<List <Product>> getProduct()
	{
		List<Product> products = productDAO.findAll();
		return ResponseEntity.ok(products);
	}

	@RequestMapping(value = "{productId}") // products/{productId}
	public ResponseEntity<Product> getProductById(@PathVariable("productId")  Long productId)
	{
		Optional<Product> optionalProduct = productDAO.findById(productId);

		if(optionalProduct.isPresent())
		{
			return ResponseEntity.ok( optionalProduct.get() );
		} else {
			return ResponseEntity.noContent().build();
		}

	}

	/*
	 * Metodo POST donde recive un JSON con el nombre del producto
	 * le asigna un ID de manera automatica y lo guarda en la 
	 * base de datos.
	 * 
	 * Se ejecuta en /products con el metodo POST
	 */
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value = "{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId")  Long productId)
	{
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Optional<Product> optionalProduct = productDAO.findById(product.getId());

		if(optionalProduct.isPresent())
		{
			Product updateProduct = optionalProduct.get();
			updateProduct.setName(product.getName());
			productDAO.save(updateProduct);
			
			return ResponseEntity.ok(updateProduct);
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	/*
	 * GetMapping Cuando entren a localhost:8080/ se inicializa con
	 * este metodo  
	 */

	/*
	@GetMapping 
	public String helloGET()
	{
		return "Hello World!!";
	}
	 */
	/*
	 * RequestMapping Permite generar URI'S personalizadas
	 * ya que en esta inicializa con localhost:8080/hello
	 */
	/*
	@RequestMapping(value="hello", method = RequestMethod.GET) //Aqui entra con /hello
	public String helloURI()
	{
		return "Hello World!!";
	}
	 */
}
