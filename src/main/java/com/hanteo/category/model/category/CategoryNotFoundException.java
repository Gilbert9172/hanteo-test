package com.hanteo.category.model.category;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super("카테고리를 찾을 수 없습니다.");
    }
}
