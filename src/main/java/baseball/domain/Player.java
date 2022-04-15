package baseball.domain;

import static baseball.common.CommonValidation.threeDigitsNumberOfValidation;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    /**
     * 플레이어가 콘솔에 데이터 등록 후 데이터 유효성 검증 후 이상없으면 데이터 반환
     * @return
     */
    public String playInputAfterValidationToValue(){
        return playInputAfterValidation(getConsoleValue());
    }

    /**
     * 플레이어가 콘솔로 부터 입력한 데이터에 대한 유효성검증
     * @param playInput
     * @return
     */
    public String playInputAfterValidation(String playInput){
        if (!threeDigitsNumberOfValidation(playInput)){
            throw new IllegalArgumentException("1~9의 서로다른 3자리 숫자를 입력하세요.");
        }
        return playInput;
    }

    /**
     * 플레이어가 콘솔에 데이터 입력
     * @return
     */
    public String getConsoleValue() {
        return Console.readLine();
    }
}
