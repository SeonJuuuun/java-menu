package menu.domain;

import java.util.List;

public class Date {

    private Date() {
    }

    public static List<String> getDayOfWeek() {
        return List.of("월요일", "화요일", "수요일", "목요일", "금요일");
    }
}
