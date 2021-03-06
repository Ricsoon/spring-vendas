package com.hvendas.sistemavendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hvendas.sistemavendas.entities.Category;
import com.hvendas.sistemavendas.exception.BusinessRuleException;
import com.hvendas.sistemavendas.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public List<Category> listAll() {
		return categoryRepo.findAll();
	}

	public Optional<Category> findById(Long codigo) {
		return categoryRepo.findById(codigo);
	}

	public Category save(Category category) {
		validateDuplicatedCategory(category);
		return categoryRepo.save(category);
	}

	public Category update(Long codigo, Category category) {
		Category saveCategory = categoryValidation(codigo);
		validateDuplicatedCategory(category);
		BeanUtils.copyProperties(category, saveCategory, "codigo");
		return categoryRepo.save(saveCategory);
	}

	public void delete(Long codigo) {
		categoryRepo.deleteById(codigo);
	}

	private Category categoryValidation(Long codigo) {
		Optional<Category> category = findById(codigo);
		if (category.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return category.get();
	}

	private void validateDuplicatedCategory(Category category) {
		Category categoryFound = categoryRepo.findByName(category.getNome());
		if (categoryFound != null && categoryFound.getCodigo() != category.getCodigo()) {
			throw new BusinessRuleException(
					String.format("A categoria %s já está cadastrada.", category.getNome().toUpperCase()));
		}
	}
}
