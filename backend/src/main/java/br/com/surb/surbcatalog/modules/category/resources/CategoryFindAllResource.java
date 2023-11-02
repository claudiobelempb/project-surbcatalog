package br.com.surb.surbcatalog.modules.category.resources;

import static org.springframework.data.domain.Sort.Direction;
import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
public class CategoryFindAllResource {
  private final CategoryFindAllService categoryFindAllService;

  public CategoryFindAllResource(CategoryFindAllService categoryFindAllService) {
    this.categoryFindAllService = categoryFindAllService;
  }

  @GetMapping
  public ResponseEntity<Page<CategoryDTO>> handle(
    @RequestParam(value = "page", defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
    @RequestParam(value = "direction", defaultValue = "ASC") String diregtion,
    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
  ){
    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(diregtion), orderBy);
    Page<CategoryDTO> categories = categoryFindAllService.execute(pageRequest);
    return ResponseEntity.ok().body(categories);
  }
}
