package com.hanteo.quiz1.category.infra.persistence.jpa;

import com.hanteo.quiz1.category.model.categoryRelation.CategoryRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRelationJpaRepository extends JpaRepository<CategoryRelation, Long> {
}
