package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseballService {
    private final Player player;
    private final int gameTargetValue;
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
        convertIntValueToMap(String.valueOf(gameTargetValue), true);
    }

    /**
     * 컴퓨터 객체와 플레이어 객체를 주입 받아 값비교 후 결과값 반환
     * @return
     */

    public String comparePlayerValueAndTargetValue(){
        final String playerValue = player.playInputAfterValidationToValue();
        convertIntValueToMap(playerValue, false);
        if (player.equals(String.valueOf(gameTargetValue))){
            return "3스트라이크";
        }
        return compareMapCheck();
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
    private void mapClear(boolean isGameTarget){
        if (isGameTarget) {
            gameTargetValueMap.clear();
        }
        if (!isGameTarget) {
            playerValueMap.clear();
        }
    }

    /**
     * computer의 random 값과 Player의 입력값의 일치 여부플 판별하는 로직
     * @return
     */
    private String compareMapCheck(){
        int strikeNum =0 , ballNum = 0;
        final Iterator<Integer> iterator = playerValueMap.keySet().iterator();
        while(iterator.hasNext()){
            final Integer key = iterator.next();
            final Integer playValue = playerValueMap.get(key);
            final Integer targetValue = gameTargetValueMap.get(key);
            if (targetValue != null) {
                if (targetValue == playValue){
                    strikeNum++;
                }
                if (targetValue != playValue){
                    ballNum++;
                }
            }
        }
        return compareMapCheckResultFormat(strikeNum, ballNum);
    }

    /**
     * strikeNum와 ballNum의 결과를 받아서 StringFormat 형태로 반환
     * @return
     */
    private String compareMapCheckResultFormat(int strikeNum, int ballNum){
        if (strikeNum != 0 && ballNum != 0){
            return String.format("%d볼 %d스트라이크", ballNum, strikeNum);
        }
        if (strikeNum == 0 && ballNum == 0){
            return "낫싱";
        }
        if (strikeNum == 0){
            return String.format("%d볼", ballNum);
        }
        return String.format("%d스트라이크", strikeNum);
    }
}
