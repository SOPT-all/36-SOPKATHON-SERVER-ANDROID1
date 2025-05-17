package org.sopt.sopkathon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity(name = "user")
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    private Integer totalPrice;

    @Builder
    private UserEntity(String name, Level level, int totalPrice) {
        this.name = name;
        this.level = level;
        this.totalPrice = totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void updateLevelByTotalPrice(int totalPrice) {
        if (totalPrice >= 500_000) {
            this.level = Level.PRINCESS;
        } else if (totalPrice >= 300_000) {
            this.level = Level.NOBILITY;
        } else if (totalPrice >= 100_000) {
            this.level = Level.COMMONS;
        } else {
            this.level = Level.NOVI;
        }
    }
}
