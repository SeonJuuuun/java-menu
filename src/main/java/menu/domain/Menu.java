package menu.domain;

public class Menu {

    private final String menu;

    private Menu(String menu) {
        this.menu = menu;
    }

    public static Menu of(String menu) {
        return new Menu(menu);
    }
}
