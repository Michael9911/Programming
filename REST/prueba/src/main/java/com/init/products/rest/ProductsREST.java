package com.init.products.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping
	public ResponseEntity<List <Product>> getProduct()
	{
		
		
		return ResponseEntity.ok(product);
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
