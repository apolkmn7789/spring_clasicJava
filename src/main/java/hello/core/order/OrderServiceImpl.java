package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
/*
    주문 인터페이스대로 주문은 변하지 않음
    구현체로 서비스 정책 구현
    할인 정책을 유연하게 변경하기위해 구현 후
    주문생성 메서드 처럼 구현
 */
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

         /*
         DIP 를 위반 (인터페이스와 구현체 2개를 의존하고 있음)
         이를 해결하기 위해
         1. 관심사 분리(역할 / 책임) 분리
         2. config
         */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
