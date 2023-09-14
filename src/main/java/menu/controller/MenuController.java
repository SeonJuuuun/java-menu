package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Date;
import menu.domain.Menu;
import menu.service.MenuService;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final Map<Category, String> menuMap;
    private final MenuService menuService;
    private final RecommendService recommendService;

    public MenuController(Map<Category, String> menuMap, MenuService menuService,
        RecommendService recommendService) {
        this.menuMap = menuMap;
        this.menuService = menuService;
        this.recommendService = recommendService;
    }

    public void start() {
        OutputView.printStart();
        List<Coach> coaches = repeat(this::inputCoachName);
        inputCoachCanNotEatMenu(coaches);
        List<Category> categories = recommendMenu(coaches);
        OutputView.printRecommendResult(categories, coaches);
    }

    public List<Category> recommendMenu(List<Coach> coaches) {
        List<Category> categories = new ArrayList<>();
        for (String date : Date.getDayOfWeek()) {
            Category category = recommendService.pickOneCategory(categories);
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

    private List<Menu> inputCanNotEatMenu(Coach coach) {
        OutputView.inputMenu(coach);
        List<String> menus = splitInput(InputView.readMenus());
        return menus.stream()
            .map(Menu::of)
            .collect(Collectors.toList());
    }

    private void inputCoachCanNotEatMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<Menu> menus = repeat(() -> inputCanNotEatMenu(coach));
            if (menus != null) {
                coach.addCanNotEatMenu(menus);
            }
        }
    }

    private List<String> splitInput(String input) {
        return Arrays.stream(input.split(","))
            .collect(Collectors.toUnmodifiableList());
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return repeat(inputReader);
        }
    }
}
