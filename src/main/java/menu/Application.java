package menu;

import menu.controller.MenuController;
import menu.service.MenuService;
import menu.service.RecommendService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController(InitialMenu.initMap(), new MenuService(),
            new RecommendService());
        menuController.start();
    }
}
