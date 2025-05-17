package org.sopt.sopkathon.service;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sopt.sopkathon.domain.Category;
import org.sopt.sopkathon.domain.ProductEntity;
import org.sopt.sopkathon.domain.Region;
import org.sopt.sopkathon.dto.response.ProductDetailDto;
import org.sopt.sopkathon.dto.response.ProductInfoListDto;
import org.sopt.sopkathon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductServiceTest {
//
//    private final ProductService productService;
//    private final ProductRepository productRepository;
//    private final EntityManager em;
//
//
//    @Autowired
//    ProductServiceTest(ProductService productService, ProductRepository productRepository, EntityManager em) {
//        this.productService = productService;
//        this.productRepository = productRepository;
//        this.em = em;
//    }
//
//    @BeforeEach
//    void init(){
//        productRepository.save(ProductEntity.builder()
//                .title("태안 햇사과")
//                .body("태안의 해풍 맞고 자란 달콤한 사과")
//                .category(Category.APPLE)
//                .imageUrl("http://example.com/apple1.jpg")
//                .price(6000)
//                .region(Region.TAEAN)
//                .seller("홍길동")
//                .build());
//
//        productRepository.save(ProductEntity.builder()
//                .title("서산 꿀사과")
//                .body("당도 높은 서산 꿀사과")
//                .category(Category.APPLE)
//                .imageUrl("http://example.com/apple2.jpg")
//                .price(5500)
//                .region(Region.SEOSAN)
//                .seller("강민수")
//                .build());
//        productRepository.save(ProductEntity.builder()
//                .title("논산 설향 딸기")
//                .body("달콤하고 향긋한 논산 딸기")
//                .category(Category.STRAWBERRY)
//                .imageUrl("http://example.com/strawberry1.jpg")
//                .price(7500)
//                .region(Region.NONSAN)
//                .seller("이하늘")
//                .build());
//
//        productRepository.save(ProductEntity.builder()
//                .title("부여 생딸기")
//                .body("신선하고 탱탱한 부여 딸기")
//                .category(Category.STRAWBERRY)
//                .imageUrl("http://example.com/strawberry2.jpg")
//                .price(7200)
//                .region(Region.BUYEO)
//                .seller("김미래")
//                .build());
//        productRepository.save(ProductEntity.builder()
//                .title("공주 알밤")
//                .body("공주 특산품 알밤으로 만든 영양간식")
//                .category(Category.CHESTNUT)
//                .imageUrl("http://example.com/chestnut1.jpg")
//                .price(8000)
//                .region(Region.GONGJU)
//                .seller("조성우")
//                .build());
//
//        productRepository.save(ProductEntity.builder()
//                .title("청양 밤")
//                .body("청정 청양에서 재배된 밤")
//                .category(Category.CHESTNUT)
//                .imageUrl("http://example.com/chestnut2.jpg")
//                .price(8500)
//                .region(Region.CHEONGYANG)
//                .seller("박예린")
//                .build());
//        productRepository.save(ProductEntity.builder()
//                .title("당진 메론")
//                .body("당도가 뛰어난 당진 메론")
//                .category(Category.MELON)
//                .imageUrl("http://example.com/melon1.jpg")
//                .price(15000)
//                .region(Region.DANGJIN)
//                .seller("이승현")
//                .build());
//
//        productRepository.save(ProductEntity.builder()
//                .title("예산 고당도 메론")
//                .body("예산에서 재배된 향긋한 메론")
//                .category(Category.MELON)
//                .imageUrl("http://example.com/melon2.jpg")
//                .price(14500)
//                .region(Region.YESAN)
//                .seller("최윤정")
//                .build());
//        productRepository.save(ProductEntity.builder()
//                .title("서산 유기농 마늘")
//                .body("농약 없이 키운 서산 마늘")
//                .category(Category.GARLIC)
//                .imageUrl("http://example.com/garlic1.jpg")
//                .price(4800)
//                .region(Region.SEOSAN)
//                .seller("유재훈")
//                .build());
//
//        productRepository.save(ProductEntity.builder()
//                .title("보령 햇마늘")
//                .body("보령의 신선한 햇마늘")
//                .category(Category.GARLIC)
//                .imageUrl("http://example.com/garlic2.jpg")
//                .price(5000)
//                .region(Region.BORYEONG)
//                .seller("한수정")
//                .build());
//        productRepository.save(ProductEntity.builder()
//                .title("청양 청결미")
//                .body("청양 들판에서 자란 깨끗한 쌀")
//                .category(Category.RICE)
//                .imageUrl("http://example.com/rice1.jpg")
//                .price(22000)
//                .region(Region.CHEONGYANG)
//                .seller("정서우")
//                .build());
//
//        productRepository.save(ProductEntity.builder()
//                .title("서천쌀 20kg")
//                .body("밥맛 좋은 서천쌀")
//                .category(Category.RICE)
//                .imageUrl("http://example.com/rice2.jpg")
//                .price(25000)
//                .region(Region.SEOCHEON)
//                .seller("임다혜")
//                .build());
//
//
//    }
//
//    @Test
//    void getProductListByCategory(){
//
//        ProductInfoListDto productInfoListDto = productService.getProductListByCategory("알밤");
//
//        Assertions.assertThat(productInfoListDto.info().size()).isEqualTo(2);
//    }
//
//    @Test
//    @Transactional
//    void getProductById(){
//        ProductEntity entity = ProductEntity.builder()
//                .title("야호")
//                .body("이야호")
//                .category(Category.RICE)
//                .imageUrl("http://example.com/rice2.jpg")
//                .price(25000)
//                .region(Region.SEOCHEON)
//                .seller("이성민")
//                .build();
//        productRepository.save(entity);
//
//        Long id = entity.getId();
//
//        em.flush();
//        em.clear();
//        ProductDetailDto productDetail = productService.getProductDetail(id);
//        Assertions.assertThat(productDetail.title()).isEqualTo(entity.getTitle());
//    }
}
