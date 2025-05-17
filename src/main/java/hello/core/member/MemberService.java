package hello.core.member;

public interface MemberService {

    // 가입
    void join(Member member);
    // 찾기
    Member findByMember(Long memberId);
}
