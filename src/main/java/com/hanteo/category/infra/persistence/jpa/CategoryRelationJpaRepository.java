package com.hanteo.category.infra.persistence.jpa;

import com.hanteo.category.model.categoryRelation.CategoryRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRelationJpaRepository extends JpaRepository<CategoryRelation, Long> {
}
