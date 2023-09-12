package menu.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Coaches {

    private static final int COACHES_MIN_SIZE = 2;
    private static final int COACHES_MAX_SIZE = 5;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoachesSize(coaches);
        validateDuplicateCoaches(coaches);
        this.coaches = coaches;
    }

    private void validateCoachesSize(List<Coach> coaches){
        if (coaches.size() < COACHES_MIN_SIZE || coaches.size() > COACHES_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께해야합니다.");
        }
    }

    private void validateDuplicateCoaches(List<Coach> coaches){
        Set<Coach> checkDuplicateSet = new HashSet<>();
        for (Coach coach : coaches) {
            if(!checkDuplicateSet.add(coach)){
                throw new IllegalArgumentException("[ERROR] 코치 이름이 중복되면 안됩니다.");
            }
        }
    }
}
