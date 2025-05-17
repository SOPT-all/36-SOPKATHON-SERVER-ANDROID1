package org.sopt.sopkathon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity(name = "product")
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String seller;

    @Column(nullable = false)
    private Region region;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private int price;

    @Builder
    private ProductEntity(String title, String body, String seller, Region region, Category category, int price) {
        this.title = title;
        this.body = body;
        this.seller = seller;
        this.region = region;
        this.category = category;
        this.price = price;
    }
}
