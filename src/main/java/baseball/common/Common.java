package baseball.common;

import java.util.HashSet;
import java.util.Set;

public class Common {

    /**
     * Random한 3자리수 검증
     * @param threeDigitsPlayNumber
     * @return
     *
     * - 캡슐화를 생각하면 접급제한자는 private이어야 하는데 테스트를 위해서 public으로 변경함
     * - 같은 숫자가 존재하면 안됨
     * - 0이 포함되어 있으면 안됨
     * - 서로 다른 숫자이면 true, 같은 숫자가 하나라도 있으면 false
     */
    public static boolean threeDigitsNumberOfValidation(int threeDigitsPlayNumber){
        final String randomThreeDigitsPlayNumberToString = String.valueOf(threeDigitsPlayNumber);
        return threeDigitsNumberOfValidation(randomThreeDigitsPlayNumberToString);
    }

    public static boolean threeDigitsNumberOfValidation(String threeDigitsPlayNumber){

        // 자리수 확인
        if (!digitCheck(threeDigitsPlayNumber)) {
            return false;
        }

        // 숫자 여부확인
        if (!isNumber(threeDigitsPlayNumber)) {
            return false;
        }

        return commonValidationCheck(threeDigitsPlayNumber);
    }

    private static boolean digitCheck(String threeDigitsPlayNumberString){
        return threeDigitsPlayNumberString.length() == 3;
    }

    private static boolean isNumber(String threeDigitsPlayNumberString){
        return threeDigitsPlayNumberString.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static boolean commonValidationCheck(String randomThreeDigitsPlayNumberToString){
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
}
