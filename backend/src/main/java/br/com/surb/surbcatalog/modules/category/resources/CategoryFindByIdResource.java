package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryFindByService;
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
@RequestMapping(value = "/categories")
public class CategoryFindByIdResource {

    private final CategoryFindByService categoryFindByService;
    private final Executor executor;

    public CategoryFindByIdResource(CategoryFindByService categoryFindByService, Executor executor) {
        this.categoryFindByService = categoryFindByService;
        this.executor = executor;
    }

    @GetMapping(value = "/{categoryId}")
    public CompletableFuture<ResponseEntity<CategoryDTO>> handle(@PathVariable UUID categoryId) {
        Objects.isNull(categoryId);
        return supplyAsync(() -> categoryFindByService.execute(categoryId), executor).thenApply((category) -> ResponseEntity.ok().body(category));
    }
}
