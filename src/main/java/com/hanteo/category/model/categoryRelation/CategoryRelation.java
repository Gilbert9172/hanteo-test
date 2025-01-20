package com.hanteo.category.model.categoryRelation;

import com.hanteo.category.model.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class CategoryRelation {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "parent_idx")
    private Category parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Category child;

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return child != null;
    }
}
