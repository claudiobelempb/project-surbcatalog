package br.com.surb.surbcatalog.modules.product.resources;

import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.services.ProductFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/products")
public class ProductFindAllResource {
    private final ProductFindAllService productFindAllService;
    private final Executor executor;

    public ProductFindAllResource(ProductFindAllService productFindAllService, Executor executor) {
        this.productFindAllService = productFindAllService;
        this.executor = executor;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Page<ProductDTO>>> handle(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String diregtion,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "name", defaultValue = "name") String name
    ) {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(diregtion), orderBy);
        return CompletableFuture.supplyAsync(() -> productFindAllService.execute(pageable), executor)
                .thenApply((product) -> ResponseEntity.ok().body(product));
    }
}
