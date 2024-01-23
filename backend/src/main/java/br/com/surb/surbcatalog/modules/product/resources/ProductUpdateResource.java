package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.services.ProductUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/products")
public class ProductUpdateResource {
    private final ProductUpdateService productUpdateService;
    private final Executor executor;

    public ProductUpdateResource(ProductUpdateService productUpdateService, Executor executor) {
        this.productUpdateService = productUpdateService;
        this.executor = executor;
    }

    @PutMapping(value = "/{productId}")
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@PathVariable UUID productId, @RequestBody ProductDTO dto) {
        return supplyAsync(() -> productUpdateService.execute(productId, dto), executor).thenApply((product) -> ResponseEntity.ok().body(product));
    }
}
