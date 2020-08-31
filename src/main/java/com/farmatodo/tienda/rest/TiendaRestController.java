package com.farmatodo.tienda.rest;

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

import com.farmatodo.tienda.dto.CompraDTO;
import com.farmatodo.tienda.entity.Compra;
import com.farmatodo.tienda.entity.Producto;
import com.farmatodo.tienda.entity.Tienda;
import com.farmatodo.tienda.service.CompraService;
import com.farmatodo.tienda.service.ProductoService;
import com.farmatodo.tienda.service.TiendaService;

@RestController
@RequestMapping("/api")
public class TiendaRestController {

	private TiendaService tiendaService;
	private ProductoService productoService;
	private CompraService compraService;	
	
	@Autowired 
	public TiendaRestController(TiendaService theTiendaService, ProductoService theProductoService, CompraService unaCompraService) {
		tiendaService = theTiendaService;
		productoService = theProductoService ;
		compraService = unaCompraService;
	}
	

	@GetMapping("/tiendas/{tiendaId}")
	public Tienda getTienda(@PathVariable int tiendaId) {
		
		Tienda laTienda = tiendaService.findById(tiendaId);
		
		if (laTienda == null) {
			throw new RuntimeException("Tienda id not found - " + tiendaId);
		}
		
		return laTienda;
	}	
	
	@GetMapping("/tiendas")
	public List<Tienda> findAll() {
		return tiendaService.findAll();
	}
	
	@PostMapping("/tiendas")
	public Tienda addTienda(@RequestBody Tienda theTienda) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theTienda.setIdTienda(0);
		
		tiendaService.save(theTienda);
		
		return theTienda;
	}	

	
	@PutMapping("/tiendas")
	public Tienda updateTienda(@RequestBody Tienda theTienda) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update		
		tiendaService.save(theTienda);
		
		return theTienda;
	}

	@DeleteMapping("/tiendas/{tiendaId}")
	public String deleteTienda(@PathVariable int tiendaId) {
		
		Tienda tempTienda = tiendaService.findById(tiendaId);
		
		// throw exception if null
		
		if (tempTienda == null) {
			throw new RuntimeException("Employee id not found - " + tiendaId);
		}
		
		tiendaService.deleteById(tiendaId);
		
		return "Deleted tienda id - " + tiendaId;
	}
	
	@PostMapping("/tiendas/hacerCompra")
	public Compra hacerCompra(@RequestBody CompraDTO compraDTO) {
	   Compra compra = null ;
	   
	   List<Producto> lstProductos = tiendaService.productosExistentes(compraDTO.getIdTienda(), compraDTO.getIdProductos() );

	   /* lstProductos son los productos con estado DISPOBIBLE que tiene la tienda */
	   /* Vamos a marcar estos productos como vendidos */
	   productoService.marcarProductosComoVendidos(lstProductos);
	   
	   compra = new Compra(compraDTO.getIdTienda(), compraDTO.getIdCliente(), lstProductos)  ;
	   
	   try {
	      compraService.save(compra);
	   }
	   catch (Exception exc) {
		  exc.printStackTrace(); 
	   }
	   return compra;
	}
}
