package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.services.ProductFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/products")
public class ProductFindByIdResource {
    private final ProductFindByIdService productFindByIdService;
    private final Executor executor;

    public ProductFindByIdResource(ProductFindByIdService productFindByIdService, Executor executor) {
        this.productFindByIdService = productFindByIdService;
        this.executor = executor;
    }

    @GetMapping(value = "/{productId}")
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@PathVariable UUID productId) {
        Objects.isNull(productId);
        return supplyAsync(() -> productFindByIdService.execute(productId), executor).thenApply((product) -> ResponseEntity.ok().body(product));
    }
}
