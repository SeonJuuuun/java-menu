package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    @DisplayName("코치의 이름의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void checkCoachSize() throws Exception {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Coach("토"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}