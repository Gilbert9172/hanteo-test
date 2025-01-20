package com.hanteo.category.infra.persistence;

import com.hanteo.category.infra.persistence.jpa.CategoryJpaRepository;
import com.hanteo.category.model.category.Category;
import com.hanteo.category.model.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository jpaRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Category> findByTitle(String title) {
        return jpaRepository.findByTitle(title);
    }
}
