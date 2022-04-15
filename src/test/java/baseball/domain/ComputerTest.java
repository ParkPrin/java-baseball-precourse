package baseball.domain;

import static baseball.common.CommonVariable.GAME_DIGITS_VALUE_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    Computer computer;

    @BeforeEach
    void setup() {
        computer = new Computer();
    }

    @DisplayName("3자리 랜덤한 숫자 생성하는 테스트, 중복 검증 X, 단순 생성")
    @Test
    void createRandomThreeDigitsPlayNumberTest(){
        // when
        final String randomThreeDigitsPlayNumber = computer.createRandomThreeDigitsPlayNumber();

        // then
        assertEquals(GAME_DIGITS_VALUE_SIZE, randomThreeDigitsPlayNumber.length());
    }

    @DisplayName("야구게임에서 지정된 3자리 랜덤한 숫자 테스트, 세자리 숫자가 다 달라야한다")
    @Test
    void getRandomThreeDigitsPlayNumberTest(){
        // ginven
        final String randomThreeDigitsPlayNumber = computer.createRandomThreeDigitsPlayNumber();

        // when
        Set<Character> randomThreeDigitsPlayNumbers = new HashSet<>();
        for(char c: randomThreeDigitsPlayNumber.toCharArray()){
            randomThreeDigitsPlayNumbers.add(c);
        }

        // then
        assertEquals(GAME_DIGITS_VALUE_SIZE, randomThreeDigitsPlayNumbers.size());
    }




}