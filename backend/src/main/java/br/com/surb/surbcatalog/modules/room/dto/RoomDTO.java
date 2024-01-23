package br.com.surb.surbcatalog.modules.room.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

//@RoomCreateValid
public record RoomDTO(UUID roomId, String name, Integer seats, OffsetDateTime createdAt, OffsetDateTime updatedAt,
                      Boolean active) {
}
