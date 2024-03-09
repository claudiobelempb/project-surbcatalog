package br.com.surb.surbcatalog.modules.notification.dto;

import br.com.surb.surbcatalog.modules.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8813976625534658161L;

    private UUID notificationId;
    private String text;
    private String route;
    private boolean read;
    private boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    private UUID userId;
}
