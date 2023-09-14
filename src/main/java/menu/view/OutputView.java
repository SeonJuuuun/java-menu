package menu.view;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Date;
import menu.domain.Menu;

public class OutputView {

    private static final String LINE_BREAK = "\n";

    private OutputView() {
    }

    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void inputCoachName() {
        System.out.print(LINE_BREAK);
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void inputMenu(Coach coach) {
        System.out.print(LINE_BREAK);
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void printRecommendResult(List<Category> categories, List<Coach> coaches) {
        System.out.print(LINE_BREAK);
        System.out.println("메뉴 추천 결과입니다.");
        printDivisions();
        printCategories(categories);
        printCoaches(coaches);
        printEnd();
    }

    private static void printDivisions() {
        List<String> divisions = new ArrayList<>();
        divisions.add("구분");
        divisions.addAll(Date.getDayOfWeek());
        System.out.println(joinWords(divisions));
    }

    private static void printCategories(List<Category> recommendedCategories) {
        List<String> categories = new ArrayList<>();
        categories.add("카테고리");
        recommendedCategories.stream().map(Category::toString).forEach(categories::add);
        System.out.println(joinWords(categories));
    }

    private static void printCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            printCoach(coach);
        }
    }

    private static void printCoach(Coach coach) {
        List<String> coachMenus = new ArrayList<>();
        coachMenus.add(coach.toString());
        coach.getCanEat().stream().map(Menu::toString).forEach(coachMenus::add);
        System.out.println(joinWords(coachMenus));
    }

    public static void printEnd() {
        System.out.print(LINE_BREAK);
        System.out.print("추천을 완료했습니다.");
    }

    public static String joinWords(List<String> words) {
        String result = "[ ";
        result += String.join(" | ", words);
        result += " ]";
        return result;
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
