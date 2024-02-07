package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.services.UserCreateService;
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
@RequestMapping(value = "/users")
public class UserCreateResource {
    private final UserCreateService userCreateService;
    private final Executor executor;

    public UserCreateResource(UserCreateService userCreateService, Executor executor) {
        this.userCreateService = userCreateService;
        this.executor = executor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<UserDTO>> handle(@Valid @RequestBody UserCreateDTO dto) {
        UserDTO userDTO = userCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{useId}").buildAndExpand(userDTO.getUserId()).toUri();
        return supplyAsync(() -> userDTO, executor).thenApply((r) -> ResponseEntity.created(uri).body(userDTO));
    }
}
