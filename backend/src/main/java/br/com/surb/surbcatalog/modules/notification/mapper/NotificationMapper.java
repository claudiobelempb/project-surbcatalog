package br.com.surb.surbcatalog.modules.notification.mapper;

import br.com.surb.surbcatalog.modules.notification.dto.NotificationDTO;
import br.com.surb.surbcatalog.modules.notification.entities.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public static NotificationDTO entityToDTO(Notification entity){
        return NotificationDTO.builder()
                .notificationId(entity.getNotificationId())
                .text(entity.getText())
                .route(entity.getRoute())
                .read(entity.isRead())
                .createdAt(entity.getCreatedAt())
                .active(entity.isActive())
                .build();
    }

}
