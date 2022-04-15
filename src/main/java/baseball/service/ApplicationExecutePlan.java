package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class ApplicationExecutePlan {
    private final Computer computer;
    private final Player player;

    public ApplicationExecutePlan(Computer computer, Player player){
        this.computer = computer;
        this.player = player;
    }

    /**
     * 실제 실행계획
     */
    public void executePlan(){
        BaseballService baseballService = getBaseballServiceInstance();
        while(true){
            System.out.print("숫자를 입력하시오: ");
            final String gameStepResult = baseballService.comparePlayerValueAndTargetValue();
            gameStepResultPrint(gameStepResult);
            if (gameStepResult.equals("3스트라이크")){
                if (isPassAfterExit(baseballService)) {
                    break;
                }
                baseballService = getBaseballServiceInstance();
            }
            baseballService.mapClear(false);
        }
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
    private BaseballService getBaseballServiceInstance(){
        return new BaseballService(computer, player);
    }

    private void gameStepResultPrint(String gameStepResul){
        System.out.println(gameStepResul);
    }

    private void targetValuePassPrintConsole(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void illegalArgumentMessage(){
        System.out.println("잘못 입력하였습니다. 다시 입력하여주세요");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /**
     * 게임패스 이후 입력값에 따라 결과를 결정하는 실제로직
     * @return
     */
    private boolean isExitOrRestart(){
        final String input = Console.readLine();
        if (input.equals("1")) {
            return false;
        }
        if (input.equals("2")) {
            return true;
        }
        illegalArgumentMessage();
        return isExitOrRestart();
    }


}
