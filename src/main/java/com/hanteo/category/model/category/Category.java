package com.hanteo.category.model.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static jakarta.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(36)", nullable = false)
    private String title;

    public boolean hasSameTitle(String source) {
        return Objects.equals(title, source);
    }
}
