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

@RestController
@RequestMapping(value = "/categories")
public class CategoryFindByIdResource {

  private final CategoryFindByService categoryFindByService;

  public CategoryFindByIdResource(CategoryFindByService categoryFindByService) {
    this.categoryFindByService = categoryFindByService;
  }

  @GetMapping(value = "/{categoryId}")
  public ResponseEntity<CategoryDTO> handle(@PathVariable UUID categoryId){
    Objects.isNull(categoryId);
    CategoryDTO categoryDTO = categoryFindByService.execute(categoryId);
    return ResponseEntity.ok().body(categoryDTO);
  }
}
