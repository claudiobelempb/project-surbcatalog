package br.com.surb.surbcatalog.modules.notification.repositories;

import br.com.surb.surbcatalog.modules.notification.entities.Notification;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    Page<Notification> findByUser(User user, Pageable pageable);
}
