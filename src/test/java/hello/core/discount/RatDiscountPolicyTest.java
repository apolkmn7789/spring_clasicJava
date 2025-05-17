package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인")
    void vip_0(){
        //given
        Member member=new Member(1L,"memberVip", Grade.VIP);
        //then
        int discount = discountPolicy.discount(member,10000);
        //when
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP 10% 할인x")
    void vip_x(){
        //given
        Member member=new Member(1L,"memberBasic", Grade.BASIC);
        //then
        int discount = discountPolicy.discount(member,10000);
        //when
        Assertions.assertThat(discount).isEqualTo(0);
    }
}