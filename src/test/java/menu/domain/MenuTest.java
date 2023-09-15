package menu.domain;

import static menu.domain.Menu.findMenuByName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Menu")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MenuTest {

    @Test
    void findMenuByName_메서드는_존재하는_메뉴가_아니면_IllegalArgumentException을_던진다() {
        List<String> menus = Arrays.asList("규동", "우동", "미소시루");
        String menuName = "피자";

        assertThatThrownBy(() -> findMenuByName(menus, menuName)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void findMenuByName_메서드는_메뉴가_존재하면_그메뉴를_반환한다() {
        List<String> menus = Arrays.asList("규동", "우동", "미소시루");
        String menuName = "규동";

        assertThat(findMenuByName(menus, menuName)).isEqualTo(Menu.of(menuName));
    }
}