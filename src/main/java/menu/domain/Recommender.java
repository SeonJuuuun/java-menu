package menu.domain;

import static menu.domain.Menu.findMenuByName;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recommender {

    private static final int SAME_CATEGORY_MAX_COUNT = 2;
    private static final int START_BOUND = 1;

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

    public Category pickOneCategory(List<Category> recommendedCategories) {
        while (true) {
            Category category = Category.valueOf(
                Randoms.pickNumberInRange(START_BOUND, Category.values().length));
            if (!isValidCategory(recommendedCategories, category)) {
                continue;
            }
            return category;
        }
    }

    private boolean isValidCategory(List<Category> recommendedCategories, Category category) {
        long count = recommendedCategories.stream().filter(c -> c.equals(category)).count();
        return count < SAME_CATEGORY_MAX_COUNT;
    }
}
