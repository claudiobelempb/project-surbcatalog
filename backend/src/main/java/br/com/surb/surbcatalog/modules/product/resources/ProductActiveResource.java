package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.services.ProductActiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/products")
public class ProductActiveResource {
    private final ProductActiveService productActiveService;
    private final Executor executor;

    public ProductActiveResource(ProductActiveService productActiveService, Executor executor) {
        this.productActiveService = productActiveService;
        this.executor = executor;
    }

    @PatchMapping(value = "/activate/{productId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID productId) {
        return CompletableFuture
                .runAsync(() -> productActiveService.execute(productId), executor)
                .thenApply((r) -> ResponseEntity.noContent().build());
    }
}
