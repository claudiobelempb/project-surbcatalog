package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryUpdateDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/categories")
public class CategoryUpdateResource {

    private final CategoryUpdateService categoryUpdateService;
    private final Executor executor;

    public CategoryUpdateResource(CategoryUpdateService categoryUpdateService, Executor executor) {
        this.categoryUpdateService = categoryUpdateService;
        this.executor = executor;
    }

    @PutMapping(value = "/{categoryId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID categoryId, @RequestBody CategoryUpdateDTO dto) {
//        return supplyAsync(() -> categoryUpdateService.execute(categoryId, dto), executor).thenApply((category) -> ResponseEntity.ok().body(category));
        return CompletableFuture
                .runAsync(() -> categoryUpdateService.execute(categoryId, dto), executor)
                .thenApply((a) -> ResponseEntity.noContent().build());
    }
}
