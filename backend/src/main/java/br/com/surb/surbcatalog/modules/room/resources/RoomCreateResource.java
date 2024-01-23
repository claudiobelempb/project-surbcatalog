package br.com.surb.surbcatalog.modules.room.resources;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.services.RoomCreateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/rooms")
public class RoomCreateResource {
    private final RoomCreateService roomCreateService;
    private final Executor controllersExecutor;

    public RoomCreateResource(RoomCreateService roomCreateService, Executor controllersExecutor) {
        this.roomCreateService = roomCreateService;
        this.controllersExecutor = controllersExecutor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<RoomCreateDTO>> handle(@Valid @RequestBody RoomCreateDTO dto) {
        RoomCreateDTO roomCreateDTO = roomCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{roomId}").buildAndExpand(roomCreateDTO.roomId()).toUri();
        return supplyAsync(() -> roomCreateDTO, controllersExecutor).thenApply((r) -> ResponseEntity.created(uri).body(roomCreateDTO));
    }
}
