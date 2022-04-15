package baseball.service;

import static baseball.common.CommonVariable.GAME_PASS_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import baseball.domain.Computer;
import baseball.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballServiceTest {

    @DisplayName("computer Random 값을 플레이어가 맞추었을 때 - 3스트라이크")
    @Test
    void comparePlayerValueAndTargetValueTest(){
        // given
        final BaseballService baseballService = getBaseballService("123", "123");

        // when
        final String compareResult = baseballService.comparePlayerValueAndTargetValue();

        // then
        assertEquals(GAME_PASS_VALUE, compareResult);
    }

    @DisplayName("computer Random 값을 Player가 부분적으로 맞추거나 하나도 맞추지 못했을 때 ")
    @ParameterizedTest
    @CsvSource(value = {"123:425:1스트라이크", "123:325:1볼 1스트라이크", "123:365:1볼", "123:456:낫싱"}, delimiter = ':')
    void playerPlayNumberOfValidationForIsNumberCheckTest(String mComputerValue , String mPlayerValue, String expected){
        // given
        final BaseballService baseballService = getBaseballService(mComputerValue, mPlayerValue);

        // when
        final String compareResult = baseballService.comparePlayerValueAndTargetValue();

        // then
        assertEquals(expected, compareResult);
    }

    public BaseballService getBaseballService(String mComputerValue, String mPlayerValue){
        Computer mComputer = mock(Computer.class);
        when(mComputer.getRandomThreeDigitsPlayNumber()).thenReturn(mComputerValue);
        Player mPlayer = mock(Player.class);
        when(mPlayer.playInputAfterValidationToValue()).thenReturn(mPlayerValue);
        return new BaseballService(mComputer, mPlayer);
    }
}