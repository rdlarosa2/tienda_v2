package com.farmatodo.tienda.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.tienda.entity.Producto;
import com.farmatodo.tienda.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {
	
	private ProductoService productoService;

	@Autowired
	public ProductoRestController(ProductoService theProductoService) {
		productoService = theProductoService;
	}	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now() ;
	}
	

	@GetMapping("/productos/{productoId}")
	public Producto getProducto(@PathVariable int productoId) {
		
		Producto elProducto = productoService.findById(productoId);
		
		if (elProducto == null) {
			throw new RuntimeException("Producto id not found - " + productoId);
		}
		
		return elProducto;
	}	
	
	@GetMapping("/productos")
	public List<Producto> findAll() {
		return productoService.findAll();
	}
	
	@PostMapping("/productos")
	public Producto addProducto(@RequestBody Producto theProducto) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProducto.setId(0);
		
		productoService.save(theProducto);
		
		return theProducto;
	}
	
	@PutMapping("/productos")	
	public void updateById(@RequestBody Producto theProducto) {
		productoService.save(theProducto);
		// productoService.updateById(theProducto);
	}	

	@DeleteMapping("/productos/{productoId}")
	public String deleteProducto(@PathVariable int productoId) {
		
		Producto tempProducto = productoService.findById(productoId);
		
		// throw exception if null
		
		if (tempProducto == null) {
			throw new RuntimeException("Employee id not found - " + productoId);
		}
		
		productoService.deleteById(productoId);
		
		return "Deleted producto id - " + productoId;
	}
}
