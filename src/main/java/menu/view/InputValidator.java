package menu.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int COACHES_SIZE_LOWER_BOUND = 2;
    private static final int COACHES_SIZE_UPPER_BOUND = 5;
    private static final int VALID_NAME_SIZE_LOWER_BOUND = 2;
    private static final int VALID_NAME_SIZE_UPPER_BOUND = 4;
    private static final int VALID_MENU_SIZE_UPPER_BOUND = 2;
    private static final int SPLIT_INDEX = -1;

    public static void validateCoachName(String inputNames) {
        List<String> names = splitNames(inputNames);
        validateNames(names);
        validateSize(names);
        validateDuplicateCoachNames(names);
    }

    private static List<String> splitNames(String inputNames) {
        return Arrays.stream(inputNames.split(",", SPLIT_INDEX))
            .collect(Collectors.toList());
    }

    private static void validateDuplicateCoachNames(List<String> names){
        Set<String> coachNames = new HashSet<>();
        for(String coach : names){
            if(!coachNames.add(coach)){
                throw new IllegalArgumentException("[ERROR] 코치 이름이 중복되면 안됩니다.");
            }
        }
    }

    private static void validateNames(List<String> names) {
        boolean result = names.stream().anyMatch(InputValidator::validateName);
        if (result) {
            throw new IllegalArgumentException("[ERROR] 코치님의 이름은 2~4 글자여야 합니다.");
        }
    }

    private static boolean validateName(String name) {
        return name.length() < VALID_NAME_SIZE_LOWER_BOUND
            || name.length() > VALID_NAME_SIZE_UPPER_BOUND;
    }

    private static void validateSize(List<String> names) {
        if (names.size() < COACHES_SIZE_LOWER_BOUND || COACHES_SIZE_UPPER_BOUND < names.size()) {
            throw new IllegalArgumentException("[ERROR] 코치님의 인원은 2~5명이어야 합니다.");
        }
    }

    public static void validateMenuNames(String inputNames) {
        List<String> names = splitNames(inputNames);
        validateMenuSize(names);
        validateDuplicateMenu(names);
    }

    private static void validateMenuSize(List<String> names) {
        if (VALID_MENU_SIZE_UPPER_BOUND < names.size()) {
            throw new IllegalArgumentException("[ERROR] 싫어하는 음식은 0~2개여야 합니다.");
        }
    }

    private static void validateDuplicateMenu(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("[ERROR] 각 메뉴는 중복될 수 없습니다.");
            }
        }
    }
}