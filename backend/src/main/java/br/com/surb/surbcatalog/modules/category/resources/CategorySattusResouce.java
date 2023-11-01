package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/categories")
public class CategorySattusResouce {
  private final CategoryStatusService categoryStatusService;

  public CategorySattusResouce(CategoryStatusService categoryStatusService) {
    this.categoryStatusService = categoryStatusService;
  }

  @PatchMapping(value = "/active/{categoryId}")
  public ResponseEntity<Void> handle(@PathVariable UUID categoryId, @RequestBody CategoryDTO categoryDTO){
    categoryStatusService.execute(categoryId, categoryDTO);
    return ResponseEntity.noContent().build();
  }
}
