package menu.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
