package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/categories")
public class CategoryCreateResource {
  private final CategoryCreateService categoryCreateService;

  public CategoryCreateResource(CategoryCreateService categoryCreateService) {
    this.categoryCreateService = categoryCreateService;
  }

  @PostMapping
  public ResponseEntity<CategoryDTO> handle(@RequestBody CategoryDTO categoryDTO){
    categoryDTO = categoryCreateService.execute(categoryDTO);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{categoryId}")
      .buildAndExpand(categoryDTO.getCategoryId())
      .toUri();
    return ResponseEntity.created(uri).body(categoryDTO);
  }
}
