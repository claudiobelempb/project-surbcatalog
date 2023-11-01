package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/categories")
public class CategoryUpdateResource {

  private final CategoryUpdateService categoryUpdateService;

  public CategoryUpdateResource(CategoryUpdateService categoryUpdateService) {
    this.categoryUpdateService = categoryUpdateService;
  }

  @PutMapping(value = "/{categoryId}")
  public ResponseEntity<CategoryDTO> handle(@PathVariable UUID categoryId, @RequestBody CategoryDTO categoryDTO){
    categoryDTO = categoryUpdateService.execute(categoryId, categoryDTO);
    return ResponseEntity.ok().body(categoryDTO);
  }
}
