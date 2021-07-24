package com.rosenatobarreto.cadastroproduto.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosenatobarreto.cadastroproduto.entities.Category;
import com.rosenatobarreto.cadastroproduto.repositories.CategoryRepository;

@RestController //definição de recurso rest
@RequestMapping(value = "/categories")//define o caminho pelo qual o recurso responde
public class CategoryResource {

	@Autowired //injecao de dependencia
	private CategoryRepository categoryRepository;
	
	@GetMapping //método abaixo retorna todas categorias
	public ResponseEntity<List<Category>> findAll() { //ResponseEntity encapsula uma resposta http
		List<Category> list = categoryRepository.findAll();
		
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {//caminho para o id
		Category cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}
