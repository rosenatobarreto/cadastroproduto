package com.rosenatobarreto.cadastroproduto.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosenatobarreto.cadastroproduto.entities.Product;
import com.rosenatobarreto.cadastroproduto.repositories.ProductRepository;

@RestController //definição de recurso rest
@RequestMapping(value = "/products")//define o caminho pelo qual o recurso responde
public class ProductResource {

	@Autowired //injecao de dependencia
	private ProductRepository categoryRepository;
	
	@GetMapping //método abaixo retorna todas categorias
	public ResponseEntity<List<Product>> findAll() { //ResponseEntity encapsula uma resposta http
		List<Product> list = categoryRepository.findAll();
		
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {//caminho para o id
		Product cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}
