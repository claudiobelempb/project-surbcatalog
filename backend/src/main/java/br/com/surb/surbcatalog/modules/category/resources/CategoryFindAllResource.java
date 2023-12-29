package br.com.surb.surbcatalog.modules.category.resources;

import static org.springframework.data.domain.Sort.Direction;
import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "categories")
public class CategoryFindAllResource {
  private final CategoryFindAllService categoryFindAllService;
  private final Executor executor;

  public CategoryFindAllResource(CategoryFindAllService categoryFindAllService, Executor executor) {
    this.categoryFindAllService = categoryFindAllService;
    this.executor = executor;
  }

  @GetMapping
  public CompletableFuture<ResponseEntity<Page<CategoryDTO>>> handle(
    @RequestParam(value = "page", defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
    @RequestParam(value = "direction", defaultValue = "ASC") String diregtion,
    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
    @RequestParam(value = "name", defaultValue = "name") String name
  ){
    Pageable pageable = PageRequest.of(page, linesPerPage, Direction.valueOf(diregtion), orderBy);
    return CompletableFuture.supplyAsync(() -> categoryFindAllService.execute(pageable), executor)
            .thenApply((category) -> ResponseEntity.ok().body(category));
  }
}
