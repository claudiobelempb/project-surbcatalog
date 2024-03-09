package br.com.surb.surbcatalog.modules.notification.services;

import br.com.surb.surbcatalog.modules.notification.dto.NotificationDTO;
import br.com.surb.surbcatalog.modules.notification.entities.Notification;
import br.com.surb.surbcatalog.modules.notification.mapper.NotificationMapper;
import br.com.surb.surbcatalog.modules.notification.repositories.NotificationRepository;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.services.UserAuthService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationFindAllUserService {
    private final NotificationRepository notificationRepository;
    private final UserAuthService userAuthService;

    public NotificationFindAllUserService(NotificationRepository notificationRepository, UserAuthService userAuthService) {
        this.notificationRepository = notificationRepository;
        this.userAuthService = userAuthService;
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> execute(Pageable pageable) {
        User user = userAuthService.execute();
        Page<Notification> notifications = notificationRepository.findByUser(user, pageable);
        return notifications.map((notification) -> NotificationMapper.entityToDTO(notification));
    }
}
