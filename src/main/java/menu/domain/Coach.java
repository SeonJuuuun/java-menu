package menu.domain;

public class Coach {

    private static final int COACH_NAME_MIN_SIZE = 2;
    private static final int COACH_NAME_MAX_SIZE = 4;

    private final String name;

    public Coach(String name) {
        validateCoachNameSize(name);
        this.name = name;
    }

    private void validateCoachNameSize(String name) {
        if(name.length() < COACH_NAME_MIN_SIZE || name.length() > COACH_NAME_MAX_SIZE){
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 입니다.");
        }
    }
}
