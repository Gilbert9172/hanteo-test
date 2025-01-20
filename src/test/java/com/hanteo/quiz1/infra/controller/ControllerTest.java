package com.hanteo.quiz1.infra.controller;

import com.hanteo.quiz1.category.infra.controller.CategoryController;
import com.hanteo.quiz1.util.JsonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private CategoryController sut;

    @Test
    @DisplayName("루트 부터 카테고리 조회")
    void categoryStructureFormRoot() {
        var categoryNodesView = sut.fullCategoryStructure();
        String jsonString = JsonUtil.toJson(categoryNodesView);
        assertThat(jsonString).contains("남자", "여자", "익명게시판");
    }

    @Test
    @DisplayName("고유값으로 검색")
    void categoryStructureFormId() {
        var categoryNodesView = sut.categoryStructureFromId(2L);
        String jsonString = JsonUtil.toJson(categoryNodesView);
        assertThat(jsonString).contains("로제");
    }

    @Test
    @DisplayName("제목으로 검색")
    void categoryStructureFormTitle() {
        var categoryNodesView = sut.categoryStructureFromTitle("엑소");
        String jsonString = JsonUtil.toJson(categoryNodesView);
        assertThat(jsonString).contains("첸", "백현", "시우민", "공지사항");
    }
}
