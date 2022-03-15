package com.hvendas.sistemavendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvendas.sistemavendas.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
