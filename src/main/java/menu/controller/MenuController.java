package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Date;
import menu.domain.Menu;
import menu.service.MenuService;
import menu.utils.Util;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final Map<Category, String> menuMap;
    private final MenuService menuService;

    public MenuController(Map<Category, String> menuMap, MenuService menuService) {
        this.menuMap = menuMap;
        this.menuService = menuService;
    }

    public void start() {
        OutputView.printStart();
        List<Coach> coaches = inputCoachName();
        for (Coach coach : coaches) {
            OutputView.inputMenu(coach);
            List<Menu> menus = inputCanNotEatMenu();
            coach.addCanNotEatMenu(menus);
        }
        List<Category> categories = recommendMenu(coaches);
        OutputView.printRecommendResult(categories, coaches);
    }

    public List<Category> recommendMenu(List<Coach> coaches) {
        List<Category> categories = new ArrayList<>();
        for (String date : Date.getDayOfWeek()) {
            Category category = Category.valueOf(Util.randomGenerator());
            for (Coach coach : coaches) {
                Menu menu = menuService.recommendMenuForCoach(menuMap, category, coach);
                coach.addCanEatMenu(menu);
            }
            categories.add(category);
        }
        return categories;
    }

    private List<Coach> inputCoachName() {
        OutputView.inputCoachName();
        List<String> coachNames = splitInput(InputView.readCoachName());
        return coachNames.stream()
            .map(Coach::new)
            .collect(Collectors.toList());
    }

    private List<Menu> inputCanNotEatMenu() {
        List<String> menus = splitInput(InputView.readMenus());
        return menus.stream()
            .map(Menu::of)
            .collect(Collectors.toList());
    }

    private List<String> splitInput(String input) {
        return Arrays.stream(input.split(","))
            .collect(Collectors.toUnmodifiableList());
    }
}
