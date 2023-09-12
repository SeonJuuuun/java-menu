package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @DisplayName("입력된 코치의 수가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void checkCoachesSize() throws Exception {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Coaches(List.of(new Coach("토미")))).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("입력된 코치들이 중복이 되면 예외가 발생한다.")
    @Test
    void checkDuplicateCoaches() throws Exception {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Coaches(
            List.of(new Coach("토미"),new Coach("토미"))))
            .isInstanceOf(IllegalArgumentException.class);
    }
}