package br.com.surb.surbcatalog.modules.notification.services;

import br.com.surb.surbcatalog.modules.notification.dto.NotificationDTO;
import br.com.surb.surbcatalog.modules.notification.entities.Notification;
import br.com.surb.surbcatalog.modules.notification.mapper.NotificationMapper;
import br.com.surb.surbcatalog.modules.notification.repositories.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationFindAllService {
    private final NotificationRepository notificationRepository;

    public NotificationFindAllService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> execute(Pageable pageable) {
        Page<Notification> notifications = notificationRepository.findAll(pageable);
        return notifications.map((notification) -> NotificationMapper.entityToDTO(notification));
    }
}
