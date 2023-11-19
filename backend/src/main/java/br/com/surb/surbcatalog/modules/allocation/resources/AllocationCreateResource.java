package br.com.surb.surbcatalog.modules.allocation.resources;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.services.AllocationCreateService;
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
@RequestMapping(value = "/allocations")
public class AllocationCreateResource {

    private final AllocationCreateService allocationCreateService;
    private final Executor executor;

    public AllocationCreateResource(AllocationCreateService allocationCreateService, Executor executor) {
        this.allocationCreateService = allocationCreateService;
        this.executor = executor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<AllocationDTO>> handle(@RequestBody AllocationCreateDTO dto){
        AllocationDTO allocationDTO = allocationCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{allocationId}").buildAndExpand(allocationDTO.getAllocationId()).toUri();
        return supplyAsync(() -> allocationDTO, executor).thenApply((r) -> ResponseEntity.created(uri).body(allocationDTO));
    }
}
