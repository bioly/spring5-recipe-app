package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CategoryCommandToCategoryTest {

    final Long ID = 100L;
    final String DESCRIPTION = "This is a description test 123";
    CategoryCommandToCategory conventer;

    @Before
    public void setUp() throws Exception {
        conventer = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(conventer.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(conventer.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);

        // when
        Category category = conventer.convert(categoryCommand);

        // then
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

}