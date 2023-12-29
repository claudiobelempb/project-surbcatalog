package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.services.CategoryActiveService;
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
public class CategoryActiveResouce {
    private final CategoryActiveService categoryActiveService;
    private final Executor executor;


    public CategoryActiveResouce(CategoryActiveService categoryActiveService, Executor executor) {
        this.categoryActiveService = categoryActiveService;
        this.executor = executor;
    }

    @PatchMapping(value = "/activate/{categoryId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID categoryId) {
        return CompletableFuture
                .runAsync(() -> categoryActiveService.execute(categoryId), executor)
                .thenApply((r) -> ResponseEntity.noContent().build());
    }
}
