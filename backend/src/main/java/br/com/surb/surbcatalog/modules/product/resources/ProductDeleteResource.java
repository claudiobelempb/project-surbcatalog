package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.services.ProductDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/products")
public class ProductDeleteResource {

    private final ProductDeleteService productDeleteService;
    private final Executor executor;

    public ProductDeleteResource(ProductDeleteService productDeleteService, Executor executor) {
        this.productDeleteService = productDeleteService;
        this.executor = executor;
    }

    @DeleteMapping(value = "/{productId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID productId) {
        return CompletableFuture
                .runAsync(() -> productDeleteService.execute(productId), executor)
                .thenApply((r) -> ResponseEntity.noContent().build());
    }
}
