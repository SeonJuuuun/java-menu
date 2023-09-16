package menu;

import menu.controller.MenuController;
import menu.domain.Recommender;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(InitialMenu.initMap(),
            new Recommender());
        menuController.start();
    }
}
