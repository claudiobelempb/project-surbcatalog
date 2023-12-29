package br.com.surb.surbcatalog.modules.category.dto;

import java.util.UUID;

public record CategoryUpdateDTO(UUID categoryId, String name) {
}
