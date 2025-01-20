package com.hanteo.quiz1.category.service;

import com.hanteo.quiz1.category.model.category.CategoryGraph;
import com.hanteo.quiz1.category.model.category.CategoryNode;
import com.hanteo.quiz1.category.model.categoryRelation.CategoryRelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRelationRepository categoryRelationRepository;

    @Transactional(readOnly = true)
    public List<CategoryNode> getCategoryFromRoot() {
        var categoryRelations = categoryRelationRepository.findAll();
        var categoryGraph = CategoryGraph.from(categoryRelations);
         return categoryGraph.buildFromRoot();
    }

    @Transactional(readOnly = true)
    public CategoryNode getCategoryFromId(Long id) {
        var categoryRelations = categoryRelationRepository.findAll();
        var categoryGraph = CategoryGraph.from(categoryRelations);
         return categoryGraph.buildFromId(id);
    }

    @Transactional(readOnly = true)
    public List<CategoryNode> getCategoryFromTitle(String title) {
        var categoryRelations = categoryRelationRepository.findAll();
        var categoryGraph = CategoryGraph.from(categoryRelations);
        return categoryGraph.buildFromTitle(title);
    }
}
