package br.com.surb.surbcatalog.modules.room.resources;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.services.RoomFindByIdService;
import br.com.surb.surbcatalog.shared.AppUtils.AppResponseEntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/rooms")
public class RoomFindByIdResource {
    private final RoomFindByIdService roomFindByIdService;
    private final Executor controllersExecutor;

    public RoomFindByIdResource(RoomFindByIdService roomFindByIdService, Executor controllersExecutor) {
        this.roomFindByIdService = roomFindByIdService;
        this.controllersExecutor = controllersExecutor;
    }

    @GetMapping(value = "/{roomId}")
    public CompletableFuture<ResponseEntity<RoomDTO>> handle(@PathVariable UUID roomId){
        //return supplyAsync(() -> roomFindByIdService.execute(roomId), controllersExecutor).thenApply((r) -> ResponseEntity.ok().body(r));
        return supplyAsync(() -> roomFindByIdService.execute(roomId), controllersExecutor).thenApply(AppResponseEntityUtils::ok);
    }
}
