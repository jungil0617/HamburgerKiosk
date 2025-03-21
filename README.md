# 햄버거 키오스크 (POJO)

## 기능 요구 사항

1. 메뉴 관리 (관리자)
   - 각 제품은 이름, 가격, 설명, 카테고리, 재고 수량를 갖는다.
   - 품절된 상품은 사용자가 선택 할 수 없다 (보이기는 해야함)
2. 주문 기능
   - 사용자는 키오스크에서 원하는 메뉴를 선택하여 담을 수 있다.
   - 재고 수량을 넘는 수량은 선택 할 수 없다.
     - 세트의 경우 일반 버거와 수량을 공유한다.
     - 세트를 주문 할 경우 일반 버거, 감자튀김, 선택한 음료 전부 수량 -1
   - 품절된 제품은 주문할 수 없다.
   - 주문 완료시 총 금액을 계산하여 출력한다.
3. 결제 기능
   - 사용자는 현금으로 결제가 가능하다.
   - 결제가 완료되면 주문번호와 영수증(주문 내역, 결제 금액, 판매자)이 출력된다.
4. 주문 내역 조회
   - 사용자는 본인의 주문 내역을 확인 할 수 있다.
   - 주문 내역에는 주문한 메뉴, 총 금액, 결제 방식이 포함된다.

## 입력 예시
- 구현에 필요한 상품 목록을 파일 입출력을 통해 불러온다.
  - src/main/resources/products.md


- 프로그램을 시작 시 루트를 선택 할 수 있다.
~~~
1. 종료
2. 관리자 생성
3. 관리자 접속
4. 회원 생성
5. 회원 접속
~~~

```
1
```

- 관리자 생성 선택 시 관리자의 정보를 입력 받는다. 이름, 보유금액을 쉼표(,)로 구분한다.
```
관리자1, 100000
관리자2, 300000
```
- 관리자 접속 선택 시 관리자의 이름을 입력 받아. 로그인한다.
```
관리자1
```
- 회원 생성 선택 시 회원의 정보를 입력 받는다. 고유번호, 보유금액을 쉼표(,)로 구분한다.
```
1, 30000
2, 26000
```

- 회원 접속 선택 시 회원의 고유번호를 입력받는다.
```
1
```
- 구매할 상품과 수량을 입력받는다. 상품명, 수량은 하이픈(-)으로, 개별 상품은 대괄호([])로 묶어 쉼표(,)로 구분
한다.
```
[치킨버거-3],[불고기버거세트-2]
```
- 추가 구매 여부를 입력 받는다.
  - Y: 재고가 업데이트된 상품 목록을 확인 후 추가로 구매를 진행한다.
  - N: 구매를 종료한다.
~~~
Y
~~~

## 출력 예시
- 프로그램 시작 시 루트를 결정한다.
```
0. 종료
1. 관리자 생성
2. 관리자 접속
3. 회원 생성
4. 회원 접속
```

- 환영 인사와 함께 접속된 회원, 관리자, 카테고리별로 상품명, 가격, 재고, 설명을 안내한다. 만약 재고가 0개라면
품절을 출력한다.
```
=================================
안녕하세요. 1님 햄버거 가게 입니다.
현재 접속된 관리자는 관리자1입니다.
=햄버거=
-치킨버거, 7000원, 15개, 치킨으로 만든 햄버거
-치킨버거세트, 9000원, 15개, 치킨으로 만든 햄버거 세트
-불고기버거, 5000원, 6개, 불고기로 만든 햄버거
-불고기버거세트, 7000원, 6개, 불고기로 만든 햄버거 세트
-싸이버거, 4800원, 8개, 맘스터치 싸이버거
-싸이버거세트, 6800원, 8개, 맘스터치 싸이버거 세트
-한우버거, 10000원, 3개, 롯데리아 한우버거
-한우버거세트, 12000원, 3개, 롯데리아 한우버거 세트
=사이드=
-감자튀김, 2500원, 17개, 감자를 튀김
=음료수=
-콜라, 2000원, 25개, 코카콜라
-제로콜라, 2000원, 품절, 코카콜라 제로
-사이다, 2000원, 17개, 스프라이트
구매하실 상품명과 수량을 입력해 주세요. (예: [치킨버거-3],[불고기버거세트-2])
```

- 구매 상품 내역, 총 금액 정보, 회원 정보, 판매자 정보를 출력한다.

```
=====================
상품명 수량 금액
치킨버거 2 14,000
콜라 1 2,000
=====================
총구매액 3 16,000
=====================
판매자: 관리자1, 116,000
구매자: 1, 14,000
```

- 추가 구매 여부를 확인하기 위해 안내 문구를 출력한다.

```
감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
```
- 사용자가 잘못된 값을 입력했을 때, “[ERROR]”로 시작하는 오류 메시지와 함께 상황에 맞는 안내를 출력한다.
  - 구매할 상품과 수량 형식이 올바르지 않은 경우
    - [ERROR] 올바르지 않은 형식으로 입력했습니다.
  - 존재하지 않는 상품을 입력한 경우
    - [ERROR] 존재하지 않는 상품입니다.
  - 구매 수량이 재고 수량을 초과한 경우
    - [ERROR] 재고 수량을 초과하여 구매할 수 없습니다.
- 위의 예시 이외의 예외처리의 경우 고민하여 작성.

## 클래스 구조
~~~
📂 src
└── 📂 main
    ├── 📄 Main.java
    ├── 📂 admin
    │   ├── 📄 AdminService.java
    │   └── 📂 validator
    │       ├── 📄 AdminValidator.java
    ├── 📂 customer
    │   ├── 📄 CustomerService.java
    │   └── 📂 validator
    │       ├── 📄 CustomerValidator.java
    ├── 📂 file
    │   ├── 📄 ProductFileLoader.java
    ├── 📂 io
    │   ├── 📄 Input.java
    ├── 📂 kiosk
    │   ├── 📄 Kiosk.java
    ├── 📂 menu
    │   ├── 📄 ProductService.java
    ├── 📂 order
    │   ├── 📄 OrderService.java
    │   ├── 📄 Payment.java
    │   └── 📂 validator
    │       ├── 📄 OrderValidator.java
    ├── 📂 resources
    │   └── 📄 products.md
    └── 📂 util
        ├── 📄 Separator.java
~~~

## 예외 처리 방식
### User
- INVALID_INPUT("[ERROR] 올바른 형식으로 입력해주세요. (예: 관리자1, 100000)"),
- INVALID_MONEY("[ERROR] 보유 금액은 숫자로 입력해야 합니다."),
- INVALID_NEGATIVE_NUMBER("[ERROR] 음수는 사용할 수 없습니다."),
- DUPLICATE_ADMIN("[ERROR] 이미 존재하는 관리자 이름입니다."),
- ADMIN_NOT_FOUND("[ERROR] 관리자 이름을 찾을 수 없습니다.");

### File
- EMPTY_FILE("[ERROR] 파일이 존재하지 않습니다."),
- FAILED_READ_FILE("[ERROR] 파일 읽기에 실패했습니다.");

### Order
- INVALID_FORMAT("[ERROR] 올바르지 않은 형식으로 입력되었습니다."),
- PRODUCT_NOT_FOUND("[ERROR] 존재하지 않는 상품입니다."),
- INVALID_QUANTITY("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다.");
