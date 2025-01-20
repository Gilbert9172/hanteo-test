package com.hanteo.quiz1.category.infra.controller;

import com.hanteo.quiz1.category.infra.controller.view.CategoryNodeView;
import com.hanteo.quiz1.category.infra.controller.view.CategoryNodesView;
import com.hanteo.quiz1.category.model.category.CategoryNotFoundException;
import com.hanteo.quiz1.category.model.category.CategoryRepository;
import com.hanteo.quiz1.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hanteo/api/v1")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    @GetMapping("/category")
    public CategoryNodesView fullCategoryStructure() {
        var nodes = categoryService.getCategoryFromRoot();
        return CategoryNodesView.from(nodes);
    }

    @GetMapping("/category-id")
    public CategoryNodeView categoryStructureFromId(@RequestParam Long id) {
        categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        var node = categoryService.getCategoryFromId(id);
        return CategoryNodeView.from(node);
    }

    @GetMapping("/category-title")
    public CategoryNodesView categoryStructureFromTitle(@RequestParam String title) {
        boolean isEmpty = categoryRepository.findByTitle(title).isEmpty();
        if (isEmpty) {
            throw new CategoryNotFoundException();
        }
        var nodes = categoryService.getCategoryFromTitle(title);
        return CategoryNodesView.from(nodes);
    }

}
