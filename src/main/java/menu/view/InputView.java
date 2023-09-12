package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String readCoachName() {
        String name = Console.readLine();
        return name;
    }
}
