package baseball.common;

public class CommonVariable {
    // 게임에서 사용되는 3자리수
    public static final int GAME_DIGITS_VALUE_SIZE = 3;

    // 플레이어가 잘못된 형태의 데이터 입력시 발생하는 에러메세지
    public static final String PLAYER_INPUT_VALUE_ERROR = "1~9의 서로다른 3자리 숫자를 입력하세요.";

    // 실행계획 변수들
    public static final String ENTER_ANSWER_VALUE = "숫자를 입력하시오:";
    public static final String GAME_PASS_VALUE = "3스트라이크";
    public static final String GAME_PASS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_PASS_AFTER_IS_REMATCH = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_PASS_AFTER_ILLEGAL_INPUT_MESSAGE = "잘못 입력하였습니다. 다시 입력하여주세요";
    public static final String GAME_REMATCH = "1";
    public static final String GAME_EXIT = "2";

    // 비교판정 결과
    public static final String EXIST_STRIKE_AND_EXIST_BALL = "%d볼 %d스트라이크";
    public static final String NOT_EXIST_STRIKEN_AND_NOT_EXIST_BALL = "낫싱";
    public static final String EXIST_BALL = "%d볼";
    public static final String EXIST_STRIKE = "%d스트라이크";
}