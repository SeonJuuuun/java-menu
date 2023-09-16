package menu.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void getDateOfWeek_메서드는_이넘의_모든값을_반환한다() {
        List<String> week = Date.getDateOfWeek();

        Assertions.assertThat(week).hasSize(5);
    }
}