package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private static final int COACH_NAME_MIN_SIZE = 2;
    private static final int COACH_NAME_MAX_SIZE = 4;

    private final String name;
    private final List<Menu> canNotEat = new ArrayList<>();
    private final List<Menu> canEat = new ArrayList<>();

    public Coach(String name) {
        validateCoachNameSize(name);
        this.name = name;
    }

    public void addCanNotEatMenu(List<Menu> menus) {
        canNotEat.addAll(menus);
    }

    public void addCanEatMenu(Menu menu) {
        canEat.add(menu);
    }

    public boolean canNotEatMenu(Menu menu) {
        return canNotEat.contains(menu);
    }

    public boolean isAlreadyRecommended(Menu menu) {
        return canEat.contains(menu);
    }

    private void validateCoachNameSize(String name) {
        if (name.length() < COACH_NAME_MIN_SIZE || name.length() > COACH_NAME_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 입니다.");
        }
    }

    public List<Menu> getCanEat() {
        return canEat;
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

    @Override
    public String toString() {
        return name;
    }
}
