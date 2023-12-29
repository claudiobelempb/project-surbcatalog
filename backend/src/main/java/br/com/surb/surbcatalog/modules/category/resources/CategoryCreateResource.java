package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryCreateDTO;
import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryCreateService;
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
@RequestMapping(value = "/categories")
public class CategoryCreateResource {
    private final CategoryCreateService categoryCreateService;
    private final Executor executor;

    public CategoryCreateResource(CategoryCreateService categoryCreateService, Executor executor) {
        this.categoryCreateService = categoryCreateService;
        this.executor = executor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<CategoryCreateDTO>> handle(@RequestBody CategoryCreateDTO dto) {
        CategoryCreateDTO categoryDTO = categoryCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{categoryId}").buildAndExpand(categoryDTO.categoryId()).toUri();
        return supplyAsync(() -> categoryDTO, executor).thenApply((category) -> ResponseEntity.created(uri).body(categoryDTO));
    }
}
