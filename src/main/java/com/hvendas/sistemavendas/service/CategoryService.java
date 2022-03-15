package com.hvendas.sistemavendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvendas.sistemavendas.entities.Category;
import com.hvendas.sistemavendas.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> listAll(){
		return categoryRepo.findAll();
	}
	
	public Optional<Category> findById(Long codigo){
		return categoryRepo.findById(codigo);
	}
	
	public Category salvar(Category category) {
		return categoryRepo.save(category);
	}
}
