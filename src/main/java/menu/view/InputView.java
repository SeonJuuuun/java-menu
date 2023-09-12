package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String readCoachName() {
        String name = Console.readLine();
        validateBlank(name);
        return name;
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력될 수 없습니다.");
        }
    }
}
