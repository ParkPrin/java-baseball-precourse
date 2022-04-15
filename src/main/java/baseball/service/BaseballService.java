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

    public BaseballService(Computer computer, Player player){
        this.player = player;
        this.gameTargetValue = computer.getRandomThreeDigitsPlayNumber();
        gameTargetValueMap = new HashMap<>();
        playerValueMap = new HashMap<>();
        convertIntValueToMap(String.valueOf(gameTargetValue), true);
    }

    public String comparePlayerValueAndTargetValue(){
        final String playerValue = player.playInputAfterValidationToValue();
        convertIntValueToMap(playerValue, false);
        if (player.equals(String.valueOf(gameTargetValue))){
            return "3스트라이크";
        }
        return compareMapCheck();
    }

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

    private void mapClear(boolean isGameTarget){
        if (isGameTarget) {
            gameTargetValueMap.clear();
        }
        if (!isGameTarget) {
            playerValueMap.clear();
        }
    }

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
        return compareMapCheckResult(strikeNum, ballNum);
    }

    private String compareMapCheckResult(int strikeNum, int ballNum){
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
