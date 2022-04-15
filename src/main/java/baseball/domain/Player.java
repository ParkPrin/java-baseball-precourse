package baseball.domain;

import static baseball.common.CommonValidation.threeDigitsNumberOfValidation;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public String playInputAfterValidationToValue(){
        final String playInput = Console.readLine();
        System.out.println(playInput);
        if (!threeDigitsNumberOfValidation(playInput)){
            throw new IllegalArgumentException("1~9의 서로다른 3자리 숫자를 입력하세요.");
        }
        return playInput;
    }
}
