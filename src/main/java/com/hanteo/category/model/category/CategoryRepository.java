package com.hanteo.category.model.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
    List<Category> findByTitle(String title);
}
