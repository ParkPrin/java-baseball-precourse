package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ApplicationExecutePlan;

public class Application {
    /**
     * 실행계획(ApplicationExecutePlan)객체 안에 Computer 객체와 Player 객체를 주입함
     * @param args
     */

    public static void main(String[] args) {
        new ApplicationExecutePlan(new Computer(), new Player()).executePlan();
    }
}
