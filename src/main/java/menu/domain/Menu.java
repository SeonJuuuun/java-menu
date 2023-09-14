package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private final String menu;

    private Menu(String menu) {
        this.menu = menu;
    }

    public static Menu of(String menu) {
        return new Menu(menu);
    }

    public static Menu findMenuByName(List<String> menus, String menuName) {
        List<Menu> totalMenu = toMenu(menus);
        return totalMenu.stream()
            .filter(menu -> menu.checkMenuName(menuName)).findAny()
            .orElseThrow(() -> new IllegalArgumentException("음식이 존재하지 않습니다."));
    }

    private static List<Menu> toMenu(List<String> menus) {
        return menus.stream().map(Menu::of).collect(Collectors.toList());
    }

    public boolean checkMenuName(String menuName) {
        return this.menu.equals(menuName);
    }

    public String getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return menu;
    }
}
