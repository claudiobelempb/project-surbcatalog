package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.services.ProductDeactiveService;
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
public class ProductDeactiveResource {
    private final ProductDeactiveService productDeactiveService;
    private final Executor executor;

    public ProductDeactiveResource(ProductDeactiveService productDeactiveService, Executor executor) {
        this.productDeactiveService = productDeactiveService;
        this.executor = executor;
    }

    @PatchMapping(value = "/deactivate/{productId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID productId) {
        return CompletableFuture
                .runAsync(() -> productDeactiveService.execute(productId), executor)
                .thenApply((result) -> ResponseEntity.noContent().build());
    }
}
