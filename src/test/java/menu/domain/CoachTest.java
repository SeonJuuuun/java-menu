package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Coach")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"호", "일곱글자입니다"})
    void 생성자_코치이름_길이가_2이상_4이하가_아닌경우_IllegalArgumentException을_던진다(String name) {
        assertThatThrownBy(() -> new Coach(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"코치", "코치임", "코치명임"})
    void 생성자_코치이름_길이가_2와_4사이인_경우_예외를_던지지_않는다(String name) {
        Assertions.assertThatNoException().isThrownBy(() -> new Coach(name));
    }

    @Test
    void addCanNotEatMenu_메서드는_추천하는_음식을_추가한다() {
        Coach coach = new Coach("코치");

        coach.addCanEatMenu(Menu.of("음식"));

        assertThat(coach.getCanEat()).containsExactly(Menu.of("음식"));
    }

    @Test
    void isAlreadyRecommended_메서드는_이미_음식이_추가되었으면_true를_반환한다() {
        Coach coach = new Coach("코치");
        Menu menu = Menu.of("김치찌개");
        coach.addCanEatMenu(menu);

        boolean result = coach.isAlreadyRecommended(menu);

        assertThat(result).isTrue();
    }

    @Test
    void isAlreadyRecommended_메서드는_음식이_추가되지_않았으면_false를_반환한다() {
        Coach coach = new Coach("코치");
        Menu menu = Menu.of("김치찌개");
        coach.addCanEatMenu(menu);

        boolean result = coach.isAlreadyRecommended(Menu.of("규동"));

        assertThat(result).isFalse();
    }
}