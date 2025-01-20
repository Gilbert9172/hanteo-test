package com.hanteo.category.model.categoryRelation;

import com.hanteo.category.model.category.Category;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryRelations {

    private final List<CategoryRelation> relations;

    private CategoryRelations(final List<CategoryRelation> relations) {
        this.relations = List.copyOf(relations);
    }

    public static CategoryRelations from(final List<CategoryRelation> relations) {
        return new CategoryRelations(relations);
    }

    public Map<Category, List<Category>> groupingByCategory() {
        Map<Category, List<Category>> relationMap = new HashMap<>();

        for (CategoryRelation relation : relations) {
            var categories = relationMap.getOrDefault(relation.getCategory(), new ArrayList<>());
            if (relation.isLeaf()) {
                categories.add(relation.getChild());
            }
            relationMap.put(relation.getCategory(), categories);
        }

        return relationMap;
    }

    public List<Category> getRootCategories() {
        return relations.stream()
                .filter(CategoryRelation::isRoot)
                .map(CategoryRelation::getCategory)
                .distinct()
                .toList();
    }

    public Map<Long, Category> toCategoryMap() {
        return getUniqueCategories()
                .stream()
                .collect(Collectors.toMap(
                        Category::getId,
                        category -> category)
                );
    }

    private List<Category> getUniqueCategories() {
        return relations.stream()
                .map(CategoryRelation::getCategory)
                .distinct()
                .toList();
    }
}
