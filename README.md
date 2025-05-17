# 🛍 쪼매못났슈 🥔

**충청남도 못난이 농산물 마켓 플랫폼**  
유저는 상품을 주문하고, 누적 구매 금액에 따라 레벨이 자동으로 변경됩니다.  
지역 및 카테고리 분류를 통해 원하는 상품을 쉽게 탐색하고 구매할 수 있습니다.

</br>

## 🌟 Contributors

| 이름       | 주요 담당 |
|------------|-----------|
| [이현진](https://github.com/2hyunjinn)     | 🧩 **주요 기능** <br> - 주문 생성 API <br> - 상품 상세 조회 API <br> - 유저 레벨 갱신 로직 <br> - 주문 트랜잭션 처리 <br> - 레벨 갱신 로직 <br> - API 명세 작성 |
| [이성민](https://github.com/seongmin0229) | 🧩 **주요 기능** <br> - 인프라 및 CI/CD 환경 구축 <br> - 무중단 배포 구성 <br> - CI/CD 설정 및 인프라 구성 <br> - 유저 조회 API <br> - 상품 목록 조회 API <br> - API 명세 작성  |

</br>

## 🏗️ Architecture Overview



</br>

## 🧾 ERD

![ERD](https://github.com/user-attachments/assets/c942c6ff-754f-4502-8db3-4ea3ca1277d4)

</br>

## ✨ Teck Stack

| 항목 | 내용 |
| --- | --- |
| **IDE** | IntelliJ IDEA |
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.x |
| **Build Tool** | Gradle |
| **ORM** | Spring Data JPA + Hibernate |
| **Database** | MySQL (RDS) |
| **Infra/Cloud** | AWS EC2, RDS, Nginx |
| **CI/CD** | GitHub Actions + Docker + Blue/Green Deployment |
| **Docs** | Notion (API 명세) |
| **Test Tool** | JUnit5 |
| **Collab Tools** | GitHub |

---

## 📌 기능 요약

| 기능 | 설명 |
|------|------|
| 유저 정보 조회 | 닉네임, 레벨, 최대값 등 조회 |
| 상품 목록 조회 | 카테고리별 필터링 포함 |
| 상품 상세 조회 | 판매자/상품 정보 포함 |
| 상품 주문 | 수량 및 상품 ID 기반 |
| 유저 등급 자동 갱신 | 주문 총액 기반으로 등급 갱신 |
| 충청남도 지역 / 농산물 카테고리 분류 | 지역 및 카테고리 기반 탐색 가능 |

---

## 🧩 레벨 갱신 조건

| 레벨     | 조건 (누적 주문 금액 기준) |
|----------|-----------------------------|
| 노비     | 기본 |
| 평민     | 100,000원 이상 |
| 귀족     | 300,000원 이상 |
| 공주     | 500,000원 이상 |

---

## 🔗 API 명세서

👉 [Notion API 명세서 보러가기](https://tremendous-baryonyx-347.notion.site/API-update-5-18-02-30-98cae0e577244ca2a003d2dff4052a79?pvs=4)

---

## ✅ 테스트 전략

- [x] 주문을 하지 않은 유저의 totalPrice는 0, 레벨은 '노비'
- [x] 주문 한 건으로 평민 조건 만족 → 레벨 변경 테스트
- [x] 주문 여러 건으로 누적 조건 만족 → 귀족, 공주까지 테스트


## 📂 브랜치 전략

- `main` : 운영용 브랜치
- `feat/*` : 기능 개발용
- `fix/*` : 버그 수정
- `chore/*` : 문서 작성
- `dev/*` : 배포용 브랜치

---

## 📝 커밋 컨벤션

| 태그 | 설명 |
|------|------|
| `feat` | 새로운 기능 추가 |
| `fix` | 버그 수정 |
| `refactor` | 리팩토링 |
| `docs` | 문서 작성 |
| `test` | 테스트 코드 |
| `chore` | 설정 파일 변경 등 기타 작업 |
| `init` | 초기 프로젝트 설정 |

