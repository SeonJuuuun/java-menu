package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;

public class RecommendService {

    private static final int SAME_CATEGORY_MAX_COUNT = 2;
    private static final int START_BOUND = 1;

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
