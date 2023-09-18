package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Date {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THI("목요일"),
    FRI("금요일");

    private final String date;

    Date(String date) {
        this.date = date;
    }

    public static List<String> getDateOfWeek() {
        return Arrays.stream(Date.values())
            .map(Date::getDate)
            .collect(Collectors.toList());
    }

    public String getDate() {
        return date;
    }
}
