package microservices.book.socialmultiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 애플리케이션에서 곱셈을 나타내는 클래스
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Multiplication {

    // 인수
    private final int factorA;
    private final int factorB;

    // JSON (역)직렬화를 위한 빈 생성자
    Multiplication() {
        this(0, 0);
    }
}