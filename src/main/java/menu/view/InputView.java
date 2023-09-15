package menu.view;

import static menu.view.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String readCoachName() {
        String name = Console.readLine();
        validateCoachName(name);
        return name;
    }

    public static String readMenus() {
        String menus = Console.readLine();
        validateMenuNames(menus);
        return menus;
    }
}

