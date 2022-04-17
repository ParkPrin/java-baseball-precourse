package baseball.service;

import static baseball.common.CommonVariable.ENTER_ANSWER_VALUE;
import static baseball.common.CommonVariable.GAME_EXIT;
import static baseball.common.CommonVariable.GAME_PASS_AFTER_ILLEGAL_INPUT_MESSAGE;
import static baseball.common.CommonVariable.GAME_PASS_AFTER_IS_REMATCH;
import static baseball.common.CommonVariable.GAME_PASS_MESSAGE;
import static baseball.common.CommonVariable.GAME_PASS_VALUE;
import static baseball.common.CommonVariable.GAME_REMATCH;

import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class ApplicationExecutePlan {

    /**
     * 실제 실행계획
     */
    public void executePlan(BaseballService baseballService, final Computer computer, final Player player){
        while(true){
            final String gameStepResult =executePlanStartPrint(baseballService);
            if (gameStepResult.equals(GAME_PASS_VALUE)){
                if (isPassAfterExit(baseballService)) {
                    break;
                }
                baseballService = getBaseballServiceInstance(computer, player);
            }
            baseballService.mapClear(false);
        }
    }

    private String executePlanStartPrint(BaseballService baseballService){
        System.out.print(ENTER_ANSWER_VALUE);
        final String gameStepResult = baseballService.comparePlayerValueAndTargetValue();
        gameStepResultPrint(gameStepResult);
        return gameStepResult;
    }


    /**
     * 게임패스(3스트라이크)가 나오고 게임을 다시 시작할지 종료할지를 정하는 로직
     * @param baseballService
     * @return
     */
    private boolean isPassAfterExit(BaseballService baseballService ){
        baseballService.mapClear(true);
        targetValuePassPrintConsole();
        if (isExitOrRestart()){
            return true;
        }
        return false;
    }

    /**
     * BaseballService 객체 생성 또는 초기화
     * @return
     */

    public static BaseballService getBaseballServiceInstance(final Computer computer, final Player player){
        return new BaseballService(computer, player);
    }

    private void gameStepResultPrint(String gameStepResul){
        System.out.println(gameStepResul);
    }

    private void targetValuePassPrintConsole(){
        System.out.println(GAME_PASS_MESSAGE);
        System.out.println(GAME_PASS_AFTER_IS_REMATCH);
    }

    private boolean illegalArgumentMessage(){
        System.out.println(GAME_PASS_AFTER_ILLEGAL_INPUT_MESSAGE);
        System.out.println(GAME_PASS_AFTER_IS_REMATCH);
        return isExitOrRestart();
    }

    /**
     * 게임패스 이후 입력값에 따라 결과를 결정하는 실제로직
     * @return
     */
    private boolean isExitOrRestart(){
        final String input = Console.readLine();
        if (input.equals(GAME_REMATCH)) {
            return false;
        }
        if (input.equals(GAME_EXIT)) {
            return true;
        }
        return illegalArgumentMessage();
    }


}
