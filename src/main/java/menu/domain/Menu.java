package menu.domain;

import java.util.List;
import java.util.Objects;
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
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 음식이 존재하지 않습니다."));
    }

    private static List<Menu> toMenu(List<String> menus) {
        return menus.stream().map(Menu::of).collect(Collectors.toList());
    }

    private boolean checkMenuName(String menuName) {
        return this.menu.equals(menuName);
    }

    public String getMenu() {
        return menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu1 = (Menu) o;
        return Objects.equals(menu, menu1.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    @Override
    public String toString() {
        return menu;
    }
}
