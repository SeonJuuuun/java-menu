package menu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;

public class InitialMenu {

    private InitialMenu() {
    }

    private static Map<Category, String> initMap() {
        Map<Category, String> menuMap = new HashMap<>();
        menuMap.put(Category.JAPAN, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        menuMap.put(Category.KOREAN, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        menuMap.put(Category.CHINA, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        menuMap.put(Category.ASIAN, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        menuMap.put(Category.WESTERN, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
        return menuMap;
    }

    public static void initSetting() {
        initMenu(initMap());
    }

    private static void initMenu(Map<Category, String> map) {
        for (Entry<Category, String> entry : map.entrySet()) {
            List<Menu> menus = Arrays.stream(entry.getValue().split(","))
                .map(Menu::of)
                .collect(Collectors.toList());
            new Menus(menus);
        }
    }
}
