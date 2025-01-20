package com.hanteo.category.infra.controller.view;

import com.hanteo.category.model.category.CategoryNode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryNodeView {

    private CategoryNode node;

    private CategoryNodeView(CategoryNode node) {
        this.node = node;
    }

    public static CategoryNodeView from(CategoryNode source) {
        return new CategoryNodeView(source);
    }
}
