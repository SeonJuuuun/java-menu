package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.utils.Util;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final Map<Category,String> menuMap;

    public MenuController(Map<Category, String> menuMap) {
        this.menuMap = menuMap;
    }

    public void start() {
        OutputView.printStart();
        List<Coach> coaches = inputCoachName();
        for(Coach coach : coaches){
            OutputView.inputMenu(coach);
            List<Menu> menus = inputCanNotEatMenu();
            coach.addCanNotEatMenu(menus);
        }
        OutputView.printRecommendResult();
        OutputView.printCategory();
        OutputView.printEnd();
    }

    public void randomGenerateType() {
        System.out.println(Category.valueOf(Util.randomGenerator()));
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
