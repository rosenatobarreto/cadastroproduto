package com.rosenatobarreto.cadastroproduto.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rosenatobarreto.cadastroproduto.entities.Product;

//Implementacao basica de um repositorio de produtos guardando na memoria
@Component 
public class ProductRepository {
	//map para encontrar o objeto pelo id
	private Map<Long, Product> map = new HashMap<>();//dicionario, mapa... em outras linguagens
 
	public void save(Product obj) {
		map.put(obj.getId(), obj);
	}

	public Product findById(Long id) {
		return map.get(id);
	}
	
	public List<Product> findAll() {
		return new ArrayList<Product>(map.values());//Acessa valores e instancia uma nova lista com esses valores
	}
}
