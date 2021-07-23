package com.rosenatobarreto.cadastroproduto.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rosenatobarreto.cadastroproduto.entities.Category;

//Implementacao basica de um repositorio de categorias guardando na memoria
@Component 
public class CategoryRepository {
	//map para encontrar o objeto pelo id
	private Map<Long, Category> map = new HashMap<>();//dicionario, mapa... em outras linguagens
 
	public void save(Category obj) {
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) {
		return map.get(id);
	}
	
	public List<Category> findAll() {
		return new ArrayList<Category>(map.values());//Acessa valores e instancia uma nova lista com esses valores
	}
}
