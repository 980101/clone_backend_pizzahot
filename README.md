# 🍕 Pizza Order Service (Backend Clone Project)

피자 주문 서비스의 핵심 도메인을 분석하고  
**상품 → 옵션 → 장바구니 → 주문 → 결제 완료 처리** 흐름을  
REST API 기반 백엔드 서버로 구현한 학습용 프로젝트입니다.

> 실제 피자 브랜드 서비스의 구조를 참고하되,  
> 학습 목적상 **결제는 가짜 결제(confirm 방식)** 로 설계했습니다.

---

## 📌 프로젝트 목적

- 백엔드 개발 전반 흐름 경험
- 실무에 가까운 도메인 모델링 연습
- REST API 설계 및 구현
- 서버 중심의 가격 계산 및 검증 로직 구현

---

## 🛠 기술 스택

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (또는 H2)
- Springdoc OpenAPI (Swagger)
- Gradle

---

## 📅 개발 기간

- 4일 (백엔드 집중 미니 프로젝트)
  - Day1: ERD + 엔티티(상품/옵션/장바구니/주문) + 기본 API
  - Day2: 장바구니/옵션 가격 계산 로직 + 주문 생성
  - Day3: 주문 상태(생성/결제완료/취소) + 예외처리 + Swagger
  - Day4: README/테스트/리팩토링(서비스 분리)
---

## 🧩 핵심 기능

### 1. 상품 / 옵션
- 피자 상품 목록 조회
- 피자 상품 상세 조회
- 옵션 그룹(사이즈/도우/토핑) 및 옵션 항목 조회
- 필수 옵션 / 최대 선택 개수 검증

### 2. 장바구니
- 장바구니 조회
- 장바구니 상품 추가
- 옵션 선택 기반 가격 계산
- 수량 변경 / 상품 삭제
- 로그인 없이 `deviceId(UUID)` 기반 장바구니 유지

### 3. 주문
- 장바구니 기반 주문 생성
- 주문 금액 스냅샷 저장
- 주문 상태 관리
  - CREATED
  - PAID
  - CANCELED

### 4. 결제 (가짜 결제)
- 결제 준비
- 결제 완료(confirm) 처리
- 결제 금액 검증
- 주문 상태 변경

---

## 🧱 도메인 모델 개요

### 주요 엔티티
- Product
- OptionGroup
- OptionItem
- ProductOptionGroup
- Cart
- CartItem
- CartItemOption
- Order
- OrderItem
- OrderItemOption
- Payment

### 설계 원칙
- **가격은 항상 서버에서 계산**
- 주문 시점의 데이터는 스냅샷으로 저장
- 옵션 검증 로직은 서비스 계층에서 처리

---

## 🔗 API 명세 요약
Base URL : /api/v1
