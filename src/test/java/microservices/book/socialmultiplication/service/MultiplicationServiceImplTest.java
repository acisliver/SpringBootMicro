package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;
import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;


public class MultiplicationServiceImplTest {
    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Before
    public void setUp() {
        // 목 객체를 초기화합니다.
        MockitoAnnotations.initMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void checkCorrectAttemptTest() {
        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("Daeeun");
        MultiplicationResultAttempt attempt =
                new MultiplicationResultAttempt(user, multiplication, 3000, false);

        // when
        boolean result = multiplicationServiceImpl.checkAttempt(attempt);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void checkWrongAttemptTest() {
        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("Daeeun");
        MultiplicationResultAttempt attempt =
                new MultiplicationResultAttempt(user, multiplication, 2000, false);

        // when
        boolean result = multiplicationServiceImpl.checkAttempt(attempt);

        // then
        assertThat(result).isFalse();
    }

//    @Test
//    public void createRandomMultiplicationTest() {
//        // given (목 객체가 처음에 50, 다음에 30을 반환하도록 설정)
//        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
//
//        // when
//        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();
//
//        // then
//        assertThat(multiplication.getFactorA()).isEqualTo(50);
//        assertThat(multiplication.getFactorB()).isEqualTo(30);
//        assertThat(multiplication.getResult()).isEqualTo(1500);
//    }
}
