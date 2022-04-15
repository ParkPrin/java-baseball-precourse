package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComputerTest {

    private Set<Integer> randomThreeDigitsPlayNumbers;
    Computer computer;

    @BeforeEach
    void setup() {
        computer = new Computer();
        randomThreeDigitsPlayNumbers = new HashSet<>();
        randomThreeDigitsPlayNumbers.add(111);
        randomThreeDigitsPlayNumbers.add(123);
        randomThreeDigitsPlayNumbers.add(133);
        randomThreeDigitsPlayNumbers.add(347);
    }

    @DisplayName("randomThreeDigitsPlayNumberOfValidation이 정상 검증하는지 검증하는 코드, 3자리 수로만 들어간다는 전제로 테스트함")
    @ParameterizedTest
    @CsvSource(value = {"111:false", "123:true", "133:false", "347:true", "307:false"}, delimiter = ':')
    public void randomThreeDigitsPlayNumberOfValidationTest(int randomThreeDigitsPlayNumber, boolean expected){
        // Then
        assertEquals(expected, computer.randomThreeDigitsPlayNumberOfValidation(randomThreeDigitsPlayNumber));
    }

    @DisplayName("3자리 랜덤한 숫자 생성하는 테스트, 중복 검증 X, 단순 생성")
    @Test
    public void createRandomThreeDigitsPlayNumberTest(){
        // when
        final int randomThreeDigitsPlayNumber = computer.createRandomThreeDigitsPlayNumber();

        // then
        assertEquals(3, String.valueOf(randomThreeDigitsPlayNumber).length());
    }

    @DisplayName("야구게임에서 지정된 3자리 랜덤한 숫자 테스트, 세자리 숫자가 다 달라야한다")
    @Test
    public void getRandomThreeDigitsPlayNumberTest(){
        // ginven
        final int randomThreeDigitsPlayNumber = computer.getRandomThreeDigitsPlayNumber();

        // when
        Set<Character> randomThreeDigitsPlayNumbers = new HashSet<>();
        for(char c: String.valueOf(randomThreeDigitsPlayNumber).toCharArray()){
            randomThreeDigitsPlayNumbers.add(c);
        }

        // then
        assertEquals(3, randomThreeDigitsPlayNumbers.size());
    }




}