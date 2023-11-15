package br.com.surb.surbcatalog.modules.room.resources;

import br.com.surb.surbcatalog.modules.room.services.RoomDeactivateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/rooms")
public class RoomDeactivateResource {
    private final RoomDeactivateService roomDeactivateService;
    private final Executor controllersExecutor;

    public RoomDeactivateResource(RoomDeactivateService roomDeactivateService, Executor controllersExecutor) {
        this.roomDeactivateService = roomDeactivateService;
        this.controllersExecutor = controllersExecutor;
    }

    @PatchMapping(value = "/deactivate/{roomId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID roomId){
        return CompletableFuture
                .runAsync(() -> roomDeactivateService.execute(roomId), controllersExecutor)
                .thenApply((r) -> ResponseEntity.noContent().build());
        /*return CompletableFuture
                .runAsync(() -> roomDeleteService.execute(roomId), controllersExecutor)
                .thenApply(AppResponseEntityUtils::notContent);*/
    }
}
