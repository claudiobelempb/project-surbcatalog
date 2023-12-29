package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.services.CategoryDeactiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/categories")
public class CategoryDeactiveResource {
    private final CategoryDeactiveService categoryDeactiveService;
    private final Executor executor;

    public CategoryDeactiveResource(CategoryDeactiveService categoryDeactiveService, Executor executor) {
        this.categoryDeactiveService = categoryDeactiveService;
        this.executor = executor;
    }

    @PatchMapping(value = "/deactivate/{categoryId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID categoryId) {
        return CompletableFuture
                .runAsync(() -> categoryDeactiveService.execute(categoryId), executor)
                .thenApply((result) -> ResponseEntity.noContent().build());
    }
}
