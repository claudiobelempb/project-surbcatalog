package br.com.surb.surbcatalog.modules.notification.resources;

import br.com.surb.surbcatalog.modules.notification.dto.NotificationDTO;
import br.com.surb.surbcatalog.modules.notification.services.NotificationFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationFindAllResource {

    private final NotificationFindAllService notificationFindAllService;
    private final Executor executor;

    public NotificationFindAllResource(NotificationFindAllService notificationFindAllService, Executor executor) {
        this.notificationFindAllService = notificationFindAllService;
        this.executor = executor;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CompletableFuture<ResponseEntity<Page<NotificationDTO>>> handle(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size,
            @RequestParam(value = "direction", defaultValue = "ASC") String diregtion,
            @RequestParam(value = "orderBy", defaultValue = "text") String orderBy

    ) {
        Pageable pageable = PageRequest.of(page, size, Direction.valueOf(diregtion), orderBy);
        return CompletableFuture.supplyAsync(() -> notificationFindAllService.execute(pageable), executor)
                .thenApply((notifications) -> ResponseEntity.ok().body(notifications));
    }
}
