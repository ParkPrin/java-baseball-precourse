package baseball.common;

import static baseball.common.CommonValidation.threeDigitsNumberOfValidation;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CommonValidationTest {

    @DisplayName("Computer가 생성한 3자리 숫자가 규칙에 맞게 생성되었는지 검증하는 테스트, 1~9까지 서로 다른 3자리 수")
    @ParameterizedTest
    @CsvSource(value = {"111:false", "123:true", "133:false", "347:true", "307:false"}, delimiter = ':')
    void randomThreeDigitsPlayNumberOfValidationTest(int randomThreeDigitsPlayNumber, boolean expected){
        // Then
        assertEquals(expected, threeDigitsNumberOfValidation(randomThreeDigitsPlayNumber));
    }

    @DisplayName("player가 입력값이 저라룰 다르게 했을때 자리수에 따른 결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "12:false", "123:true", "3475:false"}, delimiter = ':')
    void playerPlayNumberOfValidationForThreeDigitCheckTest(int threeDigitsPlayNumber, boolean expected){
        // Then
        assertEquals(expected, threeDigitsNumberOfValidation(threeDigitsPlayNumber));
    }

    @DisplayName("player가 입력값이 숫자인지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123:true", "12a:false", "bds:false", "347d:false"}, delimiter = ':')
    void playerPlayNumberOfValidationForIsNumberCheckTest(String threeDigitsPlayNumberToString, boolean expected){
        // Then
        assertEquals(expected, threeDigitsNumberOfValidation(threeDigitsPlayNumberToString));
    }


}