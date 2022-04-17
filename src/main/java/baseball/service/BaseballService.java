package baseball.service;

import static baseball.common.CommonVariable.EXIST_BALL;
import static baseball.common.CommonVariable.EXIST_STRIKE;
import static baseball.common.CommonVariable.EXIST_STRIKE_AND_EXIST_BALL;
import static baseball.common.CommonVariable.GAME_PASS_VALUE;
import static baseball.common.CommonVariable.NOT_EXIST_STRIKEN_AND_NOT_EXIST_BALL;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseballService {
    private final Player player;
    private final String gameTargetValue;
    private Map<Integer, Integer> gameTargetValueMap;
    private Map<Integer, Integer> playerValueMap;

    /**
     * 컴퓨터 객체와 플레이어 객체를 주입 받아 값비교를 진행한다
     * @param computer
     * @param player
     */
    public BaseballService(Computer computer, Player player){
        this.player = player;
        this.gameTargetValue = computer.getRandomThreeDigitsPlayNumber();
        gameTargetValueMap = new HashMap<>();
        playerValueMap = new HashMap<>();
        convertIntValueToMap(gameTargetValue, true);
    }

    /**
     * 컴퓨터 객체와 플레이어 객체를 주입 받아 값비교 후 결과값 반환
     * @return
     */

    public String comparePlayerValueAndTargetValue(){
        final String playerValue = player.playInputAfterValidationToValue();
        convertIntValueToMap(playerValue, false);
        if (player.equals(gameTargetValue)){
            return GAME_PASS_VALUE;
        }
        return new Game().compareMapCheck(gameTargetValueMap, playerValueMap);
    }

    /**
     * 숫자를 입력받아서 각 자리별로 Map으로 키와 Value로 변환
     * @param value
     * @param isGameTarget
     */

    private void convertIntValueToMap(String value, boolean isGameTarget){
        Map<Integer, Integer> valueMap = null;
        if (isGameTarget) {
            valueMap = gameTargetValueMap;
        }
        if (!isGameTarget) {
            valueMap = playerValueMap;
        }
        final char[] chars = value.toCharArray();
        for (int i = 0; chars.length > i; i++) {
            valueMap.put(Integer.valueOf(String.valueOf(chars[i])), i);
        }
    }

    /**
     * Map초기화 로직
     * @param isGameTarget
     */
    public void mapClear(boolean isGameTarget){
        if (isGameTarget) {
            gameTargetValueMap.clear();
        }
        if (!isGameTarget) {
            playerValueMap.clear();
        }
    }
}
