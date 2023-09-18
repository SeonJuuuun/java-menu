package menu.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Category")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CategoryTest {

    @Test
    void valueOf_메서드는_value를_받으면_그에맞는_Category를_반환해야한다() {
        assertThat(Category.valueOf(3)).isEqualTo(Category.CHINA);
    }

}