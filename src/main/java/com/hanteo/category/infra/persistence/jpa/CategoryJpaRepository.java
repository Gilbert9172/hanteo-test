package com.hanteo.category.infra.persistence.jpa;

import com.hanteo.category.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    List<Category> findByTitle(String title);
}
