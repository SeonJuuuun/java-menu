package menu.view;


import static menu.view.InputValidator.validateCoachName;
import static menu.view.InputValidator.validateMenuNames;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코,", "토미토미토, 제임스제", ", ", "토,제임스", "토미,제임스,포코,포코코,포라,라면"})
    void validateCoachName_메서드는_올바르지_않은_코치명을_입력했을때_IllegalArgumentExcpetion을_던진다(String names) {
        assertThatThrownBy(() -> validateCoachName(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코", "토미,포코", "코치1,코치2,코치3,코치4,코치5", "토미,제임스,포코코,포라,포로로"})
    void validateCoachName_메서드는_올바른_코치명을_입력하면_예외를_던지지_않는다(String names) {
        assertThatNoException().isThrownBy(() -> validateCoachName(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"계란,김치,떡국"})
    void validateMenuNames_메서드는_올바르지_않은_메뉴명을_입력했을때_IllegalArgumentExcpetion을_던진다(String names) {
        assertThatThrownBy(() -> validateMenuNames(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "계란", "계란,김치"})
    void validateMenuNames_메서드는_올바른_메뉴명을_입력하면_예외를_던지지_않는다(String names) {
        assertThatNoException().isThrownBy(() -> validateMenuNames(names));
    }
}