package com.hanteo.category.model.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryNode {

    private final long id;

    private final String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<CategoryNode> childNodes = new ArrayList<>();

    private CategoryNode(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryNode from(Category category) {
        return new CategoryNode(
                category.getId(),
                category.getTitle()
        );
    }

    public void add(CategoryNode node) {
        this.childNodes.add(node);
    }
}
