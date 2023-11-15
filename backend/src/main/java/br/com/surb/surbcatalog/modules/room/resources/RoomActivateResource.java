package br.com.surb.surbcatalog.modules.room.resources;

import br.com.surb.surbcatalog.modules.room.services.RoomActivateService;
import br.com.surb.surbcatalog.modules.room.services.RoomDeactivateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/rooms")
public class RoomActivateResource {
    private final RoomActivateService roomActivateService;
    private final Executor controllersExecutor;

    public RoomActivateResource(RoomActivateService roomActivateService, Executor controllersExecutor) {
        this.roomActivateService = roomActivateService;

        this.controllersExecutor = controllersExecutor;
    }

    @PatchMapping(value = "/activate/{roomId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID roomId){
        return CompletableFuture
                .runAsync(() -> roomActivateService.execute(roomId), controllersExecutor)
                .thenApply((r) -> ResponseEntity.noContent().build());
        /*return CompletableFuture
                .runAsync(() -> roomDeleteService.execute(roomId), controllersExecutor)
                .thenApply(AppResponseEntityUtils::notContent);*/
    }
}
