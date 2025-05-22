package hello.core.autowried;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        /*
            의존 관계가 없으면 메서드 호출이 안된다.
         */
        @Autowired(required = false)
        public void setNoBean(Member noBean){
            System.out.println("noBean1 : " + noBean);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 : " + noBean2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 : " + noBean3);
        }
    }
}
