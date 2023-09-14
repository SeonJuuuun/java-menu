package menu.service;

import static menu.domain.Menu.findMenuByName;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuService {

    public Menu recommendMenuForCoach(Map<Category, String> map, Category category, Coach coach) {
        List<String> categoryMenus = Arrays.stream(map.get(category).split(","))
            .collect(Collectors.toList());
        while (true) {
            Menu menu = findMenuByName(categoryMenus, Randoms.shuffle(categoryMenus).get(0));
            if (coach.canNotEatMenu(menu) || coach.isAlreadyRecommended(menu)) {
                continue;
            }
            return menu;
        }
    }
}
