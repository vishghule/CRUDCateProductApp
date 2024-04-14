package com.example.demo.Repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category ,Integer>  {
}
