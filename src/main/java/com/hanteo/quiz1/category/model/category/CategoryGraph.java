package com.hanteo.quiz1.category.model.category;

import com.hanteo.quiz1.category.model.categoryRelation.CategoryRelations;
import java.util.List;
import java.util.Map;

public class CategoryGraph {

    private final CategoryRelations categoryRelations;
    private final Map<Long, Category> categoryMap;
    private final Map<Category, List<Category>> relationMap;

    private CategoryGraph(
            final CategoryRelations categoryRelations,
            final Map<Category, List<Category>> relationMap,
            final Map<Long, Category> categoryMap
    ) {
        this.categoryRelations = categoryRelations;
        this.relationMap = relationMap;
        this.categoryMap = categoryMap;
    }

    public static CategoryGraph from(final CategoryRelations relations) {
        return new CategoryGraph(
                relations,
                Map.copyOf(relations.groupingByCategory()),
                Map.copyOf(relations.toCategoryMap())
        );
    }

    public List<CategoryNode> buildFromRoot() {
        var rootCategories = categoryRelations.getRootCategories();
        return rootCategories.stream()
                .map(this::buildSubNode)
                .toList();
    }

    public CategoryNode buildFromId(final Long categoryId) {
        var key = categoryMap.get(categoryId);
        return buildSubNode(key);
    }

    public List<CategoryNode> buildFromTitle(final String title) {
        var categories = categoryMap.values()
                .stream()
                .filter(category -> category.hasSameTitle(title))
                .toList();

        return categories.stream()
                .map(this::buildSubNode)
                .toList();
    }

    private CategoryNode buildSubNode(final Category category) {
        var node = CategoryNode.from(category);
        var childCategories = relationMap.get(category);
        for (Category child : childCategories) {
            node.add(buildSubNode(child));
        }
        return node;
    }

}
