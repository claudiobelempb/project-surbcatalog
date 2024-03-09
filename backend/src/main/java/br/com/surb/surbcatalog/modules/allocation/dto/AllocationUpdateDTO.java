package br.com.surb.surbcatalog.modules.allocation.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

public record AllocationUpdateDTO(
        String allocationId,
        String subject,
        OffsetDateTime startAt,
        OffsetDateTime endAt,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        Boolean active,
        UUID roomId,
        String userId
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 4420848443010970862L;
}
