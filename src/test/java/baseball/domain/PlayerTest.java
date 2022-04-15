package baseball.domain;


import static baseball.common.CommonVariable.GAME_DIGITS_VALUE_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PlayerTest {

    Player player;

    @BeforeEach
    void setup() {
        this.player = new Player();
    }

    @DisplayName("플레이어가 등록한 값이 성공했을 때")
    @Test
    void playInputAfterValidationSuccessTest(){
        // when
        Player mPlayer = mock(Player.class);
        when(mPlayer.getConsoleValue()).thenReturn("123");
        final String s = player.playInputAfterValidation(mPlayer.getConsoleValue());
        Set<Character> playIntpusCharacters = new HashSet<>();
        for (char c:  s.toCharArray()) {
            playIntpusCharacters.add(c);
        }

        // then
        assertEquals(GAME_DIGITS_VALUE_SIZE, playIntpusCharacters.size());
    }

    @DisplayName("플레이어가 등록한 값이 실패했을 때")
    @ParameterizedTest
    @CsvSource(value = {"12", "12a", "3475"})
    void playInputAfterValidationFailTest(String returnValue){
        // when
        Player mPlayer = mock(Player.class);
        when(mPlayer.getConsoleValue()).thenReturn(returnValue);
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    player.playInputAfterValidation(mPlayer.getConsoleValue());
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9의 서로다른 3자리 숫자를 입력하세요.");
    }



}