package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.services.CategoryFindAllService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "categories")
public class CategoryFindAllResource {
  private final CategoryFindAllService categoryFindAllService;

  public CategoryFindAllResource(CategoryFindAllService categoryFindAllService) {
    this.categoryFindAllService = categoryFindAllService;
  }

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> handle(){
    List<CategoryDTO> categories = categoryFindAllService.execute();
    return ResponseEntity.ok().body(categories);
  }
}
