package br.com.surb.surbcatalog.modules.category.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CategoryDTO(UUID categoryId, String name, OffsetDateTime createdAt, OffsetDateTime updatedAt,
                          Boolean active) {
}
