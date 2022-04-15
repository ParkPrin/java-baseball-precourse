package baseball.domain;

import static baseball.common.CommonValidation.threeDigitsNumberOfValidation;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    /**
     * 야구게임에서 사용할 랜덤한 3자리수 제공
     * @return 랜덤한 3자리수
     */
    public int getRandomThreeDigitsPlayNumber(){
        // randomThreeDigitsPlayNumber 생성
        final int randomThreeDigitsPlayNumber = createRandomThreeDigitsPlayNumber();

        // randomThreeDigitsPlayNumber 검증
        if (threeDigitsNumberOfValidation(randomThreeDigitsPlayNumber)) {
            return randomThreeDigitsPlayNumber;
        }
        return getRandomThreeDigitsPlayNumber();
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
