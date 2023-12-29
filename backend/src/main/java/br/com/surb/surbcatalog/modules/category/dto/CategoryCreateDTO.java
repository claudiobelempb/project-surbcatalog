package br.com.surb.surbcatalog.modules.category.dto;

import java.util.UUID;

public record CategoryCreateDTO(UUID categoryId, String name) {
}
