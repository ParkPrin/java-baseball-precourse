package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ApplicationExecutePlan;

public class Application {
    public static void main(String[] args) {
        new ApplicationExecutePlan(new Computer(), new Player()).executePlan();
    }
}
