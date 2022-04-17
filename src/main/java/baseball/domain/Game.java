package baseball.domain;

import static baseball.common.CommonVariable.EXIST_BALL;
import static baseball.common.CommonVariable.EXIST_STRIKE;
import static baseball.common.CommonVariable.EXIST_STRIKE_AND_EXIST_BALL;
import static baseball.common.CommonVariable.NOT_EXIST_STRIKEN_AND_NOT_EXIST_BALL;

import java.util.Iterator;
import java.util.Map;

public class Game {

    /**
     * computer의 random 값과 Player의 입력값의 일치 여부플 판별하는 로직
     * @return
     */
    public String compareMapCheck(Map<Integer, Integer> gameTargetValueMap, Map<Integer, Integer> playerValueMap){
        int strike =0 , ball = 0;
        final Iterator<Integer> iterator = playerValueMap.keySet().iterator();
        while(iterator.hasNext()){
            final Integer key = iterator.next();
            final Integer playValue = playerValueMap.get(key);
            final Integer targetValue = gameTargetValueMap.get(key);
            if (targetValue != null) {
                if (targetValue == playValue){
                    strike++;
                }
                if (targetValue != playValue){
                    ball++;
                }
            }
        }
        return compareMapCheckResultFormat(strike, ball);
    }

    /**
     * strikeNum와 ballNum의 결과를 받아서 StringFormat 형태로 반환
     * @return
     */
    public String compareMapCheckResultFormat(int strike, int ball){
        if (strike != 0 && ball != 0){
            return String.format(EXIST_STRIKE_AND_EXIST_BALL, ball, strike);
        }
        if (strike == 0 && ball == 0){
            return NOT_EXIST_STRIKEN_AND_NOT_EXIST_BALL;
        }
        if (strike == 0){
            return String.format(EXIST_BALL, ball);
        }
        return String.format(EXIST_STRIKE, strike);
    }
}
