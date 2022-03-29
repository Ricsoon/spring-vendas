package com.hvendas.sistemavendas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hvendas.sistemavendas.entities.Category;
import com.hvendas.sistemavendas.service.CategoryService;

@RestController
@RequestMapping("/categoria")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> listAll() {
		return categoryService.listAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Long codigo) {
		Optional<Category> category = categoryService.findById(codigo);
		return category.isPresent() ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Category> save(@Valid @RequestBody Category category) {
		Category categoriaSalva = categoryService.save(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Category> update(@PathVariable Long codigo, @Valid @RequestBody Category category) {
		return ResponseEntity.ok(categoryService.update(codigo, category));
	}

}
