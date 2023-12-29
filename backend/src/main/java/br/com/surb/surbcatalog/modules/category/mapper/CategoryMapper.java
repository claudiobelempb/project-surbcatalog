package br.com.surb.surbcatalog.modules.category.mapper;

import br.com.surb.surbcatalog.modules.category.dto.CategoryCreateDTO;
import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.dto.CategoryUpdateDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryMapper() {
    }

    public static Category fromEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Category.Builder().name(dto.name()).active(dto.active()).createdAt(dto.createdAt()).updatedAt(dto.updatedAt()).build();
    }

    public static CategoryDTO fromDTO(Category entity) {
        if (entity == null) {
            return null;
        }

        return new CategoryDTO(entity.getCategoryId(), entity.getName(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getActive());

    }

    public static Category fromCreateEntity(CategoryCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Category.Builder().name(dto.name()).build();
    }

    public static CategoryCreateDTO fromCreateDTO(Category entity) {
        if (entity == null) {
            return null;
        }

        return new CategoryCreateDTO(entity.getCategoryId(), entity.getName());

    }

    public static Category fromUpdateEntity(CategoryUpdateDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Category.Builder().name(dto.name()).build();
    }

    public static CategoryUpdateDTO fromUpdateDTO(Category entity) {
        if (entity == null) {
            return null;
        }

        return new CategoryUpdateDTO(entity.getCategoryId(), entity.getName());

    }
}
