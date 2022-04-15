package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    /**
     * 야구게임에서 사용할 랜덤한 3자리수 제공
     * @return 랜덤한 3자리수
     */
    public int getRandomThreeDigitsPlayNumber(){
        // randomThreeDigitsPlayNumber 생성
        final int randomThreeDigitsPlayNumber = createRandomThreeDigitsPlayNumber();

        // randomThreeDigitsPlayNumber 검증
        if (randomThreeDigitsPlayNumberOfValidation(randomThreeDigitsPlayNumber)) {
            return randomThreeDigitsPlayNumber;
        }
        return getRandomThreeDigitsPlayNumber();
    }

    /**
     * Random한 3자리수 검증
     * @param randomThreeDigitsPlayNumber
     * @return
     *
     * - 캡슐화를 생각하면 접급제한자는 private이어야 하는데 테스트를 위해서 public으로 변경함
     * - 같은 숫자가 존재하면 안됨
     * - 0이 포함되어 있으면 안됨
     * - 서로 다른 숫자이면 true, 같은 숫자가 하나라도 있으면 false
     */
   public boolean randomThreeDigitsPlayNumberOfValidation(int randomThreeDigitsPlayNumber){
        final String randomThreeDigitsPlayNumberToString = String.valueOf(randomThreeDigitsPlayNumber);
        final char[] randomThreeDigitsPlayNumberToCharList = randomThreeDigitsPlayNumberToString.toCharArray();
        Set<Integer> randomThreeDigitsPlayNumberSet = new HashSet<>();
        for (char randomThreeDigitsPlayNumberToChar: randomThreeDigitsPlayNumberToCharList) {
            if (randomThreeDigitsPlayNumberToChar == '0') {
                return false;
            }
            randomThreeDigitsPlayNumberSet.add(Integer.valueOf(randomThreeDigitsPlayNumberToChar));
        }
        return randomThreeDigitsPlayNumberSet.size() == 3;
    }

    /**
     * 야구게임에서 사용할 랜덤한 3자리수 생성
     * @return
     * - 캡슐화를 생각하면 접급제한자는 private이어야 하는데 테스트를 위해서 public으로 변경함
     */

    public int createRandomThreeDigitsPlayNumber(){
        return Randoms.pickNumberInRange(100, 999);
    }
}
