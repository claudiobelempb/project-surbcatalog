package br.com.surb.surbcatalog.modules.allocation.resources;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.services.AllocationFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/allocations")
public class AllocationFindAllResource {

    private final AllocationFindAllService allocationFindAllService;
    private final Executor executor;

    public AllocationFindAllResource(AllocationFindAllService allocationFindAllService, Executor executor) {
        this.allocationFindAllService = allocationFindAllService;
        this.executor = executor;
    }

    /*
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @DateTimeFormat(pattern="yyyy-MM-dd")
     */
    @GetMapping
    public CompletableFuture<ResponseEntity<Page<AllocationDTO>>> handle(
            @RequestParam(value = "userId", defaultValue = "") UUID userId,
            @RequestParam(value = "roomId", defaultValue = "") UUID roomId,
            @RequestParam(value = "startAt", required = false) LocalDate startAt,
            @RequestParam(value = "endAt", required = false) LocalDate endAt,
            Pageable pageable
            //@RequestParam(value = "orderBy", defaultValue = "ASC") String orderBy,
            //@RequestParam(value = "limit", defaultValue = "0") Integer limit,
            //@RequestParam(value = "page", defaultValue = "0") Integer page
    ) {
        return CompletableFuture.supplyAsync(() -> allocationFindAllService.execute(userId, roomId, startAt, endAt, pageable), executor)
                .thenApply((r) -> ResponseEntity.ok().body(r));
    }
}
