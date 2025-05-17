package hello.core.order;
// 인터페이스
public interface OrderService {

    // 주문
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
