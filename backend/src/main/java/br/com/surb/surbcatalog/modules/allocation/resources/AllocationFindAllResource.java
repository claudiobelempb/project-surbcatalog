package br.com.surb.surbcatalog.modules.allocation.resources;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.services.AllocationFindAllService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils.DEFAULT_TIMEZONE;

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
    public CompletableFuture<ResponseEntity<List<AllocationDTO>>> handle(
            @RequestParam(value = "userId", defaultValue = "") UUID userId,
            @RequestParam(value = "roomId", defaultValue = "") UUID roomId,
            @RequestParam(value = "startAt", required = false) LocalDate startAt,
            @RequestParam(value = "endAt", required = false) LocalDate endAt
    ) {
        return CompletableFuture.supplyAsync(() -> allocationFindAllService.execute(userId, roomId, startAt, endAt), executor)
                .thenApply((r) -> ResponseEntity.ok().body(r));
    }
}
