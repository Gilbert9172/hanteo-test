package com.hanteo.quiz1.category.infra.persistence;

import com.hanteo.quiz1.category.infra.persistence.jpa.CategoryRelationJpaRepository;
import com.hanteo.quiz1.category.model.categoryRelation.CategoryRelationRepository;
import com.hanteo.quiz1.category.model.categoryRelation.CategoryRelations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRelationRepositoryImpl implements CategoryRelationRepository {

    private final CategoryRelationJpaRepository jpaRepository;

    @Override
    public CategoryRelations findAll() {
        return CategoryRelations.from(jpaRepository.findAll());
    }
}
