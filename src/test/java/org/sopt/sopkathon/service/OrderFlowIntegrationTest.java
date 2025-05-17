package org.sopt.sopkathon.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sopt.sopkathon.domain.*;
import org.sopt.sopkathon.dto.response.CreateOrderDto;
import org.sopt.sopkathon.repository.ProductRepository;
import org.sopt.sopkathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OrderFlowIntegrationTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EntityManager em;

    private UserEntity user;
    private ProductEntity product;

    @BeforeEach
    void setUp() {
        user = userRepository.save(UserEntity.builder()
                .name("현진")
                .level(Level.NOVI)
                .totalPrice(0)
                .build());

        product = productRepository.save(ProductEntity.builder()
                .title("정기 배송 상품")
                .body("친환경으로 만든 제품입니다.")
                .imageUrl("https://example.com/image.jpg")
                .seller("초록상점")
                .region(Region.GONGJOO)
                .category(Category.FRUIT)
                .price(100_000)
                .build());

    }

    @Test
    void 주문_하지_않은_유저는_totalPrice_0_Level은_노비() {
        // when
        UserEntity result = userRepository.findById(user.getId()).get();

        // then
        assertThat(result.getTotalPrice()).isZero();
        assertThat(result.getLevel()).isEqualTo(Level.NOVI);
    }

    @Test
    void 주문_금액이_10만원_미만이면_노비() {
        // when
        ProductEntity p2 = productRepository.save(ProductEntity.builder()
                .title("정기 배송 상품")
                .body("친환경으로 만든 제품입니다.")
                .imageUrl("https://example.com/image.jpg")
                .seller("초록상점")
                .region(Region.GONGJOO)
                .category(Category.FRUIT)
                .price(90_000)
                .build());

        CreateOrderDto dto = orderService.createOrder(user, p2, 1);
        userService.updateUserTotalPrice(user, dto.totalPrice());
        em.flush();
        em.clear();

        UserEntity updatedUser = userRepository.findById(user.getId()).get();

        // then
        assertThat(updatedUser.getTotalPrice()).isEqualTo(90_000);
        assertThat(updatedUser.getLevel()).isEqualTo(Level.NOVI);
    }

    @Test
    void 한번_주문시_totalPrice_업데이트되고_레벨은_평민() {
        // when
        CreateOrderDto dto = orderService.createOrder(user, product, 1);
        userService.updateUserTotalPrice(user, dto.totalPrice());
        em.flush();
        em.clear();

        UserEntity updatedUser = userRepository.findById(user.getId()).get();

        // then
        assertThat(updatedUser.getTotalPrice()).isEqualTo(100_000);
        assertThat(updatedUser.getLevel()).isEqualTo(Level.COMMONS);
    }

    @Test
    void 두번_주문시_totalPrice_누적되고_레벨_귀족으로_변경() {
        // when
        CreateOrderDto first = orderService.createOrder(user, product, 1); // 100_000
        userService.updateUserTotalPrice(user, first.totalPrice());

        CreateOrderDto second = orderService.createOrder(user, product, 2); // +200_000
        userService.updateUserTotalPrice(user, second.totalPrice());

        em.flush();
        em.clear();

        UserEntity updatedUser = userRepository.findById(user.getId()).get();

        // then
        assertThat(updatedUser.getTotalPrice()).isEqualTo(300_000);
        assertThat(updatedUser.getLevel()).isEqualTo(Level.NOBILITY);
    }
}
