package com.hanteo.category.infra.controller.view;

import com.hanteo.category.model.category.CategoryNode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CategoryNodesView {

    private List<CategoryNode> nodes;

    private CategoryNodesView(List<CategoryNode> nodes) {
        this.nodes = nodes;
    }

    public static CategoryNodesView from(List<CategoryNode> source) {
        return new CategoryNodesView(source);
    }
}
