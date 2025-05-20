package hello.core.member;

import org.springframework.stereotype.Component;

@Component /* ("service") 빈 중복 에러 */
public interface MemberRepository {

    // 회원 가입
    void save(Member member);
    // 회원 id 찾기
    Member findById(Long memberId);
}
