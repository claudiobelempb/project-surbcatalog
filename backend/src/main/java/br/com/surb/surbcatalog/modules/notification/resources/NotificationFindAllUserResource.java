package br.com.surb.surbcatalog.modules.notification.resources;

import br.com.surb.surbcatalog.modules.notification.dto.NotificationDTO;
import br.com.surb.surbcatalog.modules.notification.services.NotificationFindAllUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/users/notifications")
public class NotificationFindAllUserResource {
    private final NotificationFindAllUserService notificationFindAllService;
    private final Executor executor;

    public NotificationFindAllUserResource(NotificationFindAllUserService notificationFindAllService, Executor executor) {
        this.notificationFindAllService = notificationFindAllService;
        this.executor = executor;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Page<NotificationDTO>>> handle(Pageable pageable) {
//    Pageable pageable = PageRequest.of(page, linesPerPage, Direction.valueOf(diregtion), orderBy);
        Page<NotificationDTO> page = notificationFindAllService.execute(pageable);
        return CompletableFuture.supplyAsync(() -> page, executor)
                .thenApply((notifications) -> ResponseEntity.ok().body(notifications));
    }
}
