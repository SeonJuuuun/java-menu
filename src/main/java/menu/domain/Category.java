package menu.domain;

public enum Category {
    JAPAN(1,"일식"),
    KOREAN(2,"한식"),
    CHINA(3,"중식"),
    ASIAN(4,"아시안"),
    WESTERN(5,"양식");

    private final int value;
    private final String type;

    Category(int value, String type) {
        this.value = value;
        this.type = type;
    }
}
