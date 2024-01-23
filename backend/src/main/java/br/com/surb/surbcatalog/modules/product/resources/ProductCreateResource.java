package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.services.ProductCreateService;
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
@RequestMapping(value = "/products")
public class ProductCreateResource {
    private final ProductCreateService productCreateService;
    private final Executor executor;

    public ProductCreateResource(ProductCreateService productCreateService, Executor executor) {
        this.productCreateService = productCreateService;
        this.executor = executor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@RequestBody ProductDTO dto) {
        ProductDTO productDTO = productCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{categoryId}").buildAndExpand(productDTO.getProductId()).toUri();
        return supplyAsync(() -> productDTO, executor).thenApply((__) -> ResponseEntity.created(uri).body(productDTO));
    }
}
