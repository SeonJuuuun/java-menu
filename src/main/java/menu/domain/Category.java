package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPAN(1, "일식"),
    KOREAN(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int value;
    private final String type;

    Category(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public static Category valueOf(int number) {
        return Arrays.stream(Category.values())
            .filter(category -> category.getValue() == number)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 값 입니다."));
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return type;
    }
}
