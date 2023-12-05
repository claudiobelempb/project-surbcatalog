package br.com.surb.surbcatalog.modules.allocation.resources;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.services.AllocationFindAllPageService;
import org.springframework.data.domain.Page;
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
public class AllocationFindAllPageResource {

    private final AllocationFindAllPageService allocationFindAllPageService;
    private final Executor executor;

    public AllocationFindAllPageResource(AllocationFindAllPageService allocationFindAllPageService, Executor executor) {
        this.allocationFindAllPageService = allocationFindAllPageService;
        this.executor = executor;
    }

    /*
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @DateTimeFormat(pattern="yyyy-MM-dd")
     */
    @GetMapping(value = "/pages")
    public CompletableFuture<ResponseEntity<Page<AllocationDTO>>> handle(
            @RequestParam(value = "userId", required = false) UUID userId,
            @RequestParam(value = "roomId", required = false) UUID roomId,
            @RequestParam(value = "startAt", required = false) LocalDate startAt,
            @RequestParam(value = "endAt", required = false) LocalDate endAt,
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        return CompletableFuture.supplyAsync(() -> allocationFindAllPageService.execute(userId, roomId, startAt, endAt, orderBy, size, page), executor)
                .thenApply((r) -> ResponseEntity.ok().body(r));
    }
}
