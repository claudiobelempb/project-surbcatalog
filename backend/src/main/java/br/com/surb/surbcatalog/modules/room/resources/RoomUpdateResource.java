package br.com.surb.surbcatalog.modules.room.resources;

import br.com.surb.surbcatalog.modules.room.dto.RoomUpdateDTO;
import br.com.surb.surbcatalog.modules.room.services.RoomUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/rooms")
public class RoomUpdateResource {

    private final RoomUpdateService roomUpdateService;
    private final Executor executor;

    public RoomUpdateResource(RoomUpdateService roomUpdateService, Executor executor) {
        this.roomUpdateService = roomUpdateService;
        this.executor = executor;
    }

    @PutMapping(value = "/{roomId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID roomId, @RequestBody RoomUpdateDTO dto){
        return CompletableFuture
                .runAsync(() -> roomUpdateService.execute(roomId, dto), executor)
                .thenApply((r) -> ResponseEntity.noContent().build());
    }
}
