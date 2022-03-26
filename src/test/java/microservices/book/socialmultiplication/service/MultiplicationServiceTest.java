package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

    @MockBean   // 해당 인터페이스에 맞는 구현체를 찾아 주입하는 대신 Mock 객체를 주입
    private RandomGeneratorService randomGeneratorService;

    @Autowired  // 서비스가 구현되어 있지 않기 때문에 실패, MultiplicationImpl을 만들어 성공
    private MultiplicationService multiplicationService;

    @Test       // 테스트는 성공하지만 randomGeneratorService가 구현되지 않았기 때문에 에러 발생
    public void createRandomMultiplicationTest() {
        // given
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        // when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        // then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}
