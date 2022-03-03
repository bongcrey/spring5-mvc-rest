package guru.springfamework.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;

public class CategoryMapperTest {

    private static final long JOHN_ID = 1L;
    private static final String JOHN = "John";

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void testCategoryToCategoryDTO() {
        
        //given
        Category category = new Category();
        category.setName(JOHN);
        category.setId(JOHN_ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(JOHN_ID), categoryDTO.getId());
        assertEquals(JOHN, categoryDTO.getName());
    }
}
