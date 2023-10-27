package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.services.CategoryFindAllService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "categories")
public class CategoryFindAllResource {
  private final CategoryFindAllService categoryFindAllService;

  public CategoryFindAllResource(CategoryFindAllService categoryFindAllService) {
    this.categoryFindAllService = categoryFindAllService;
  }

  @GetMapping
  public ResponseEntity<List<Category>> handle(){
    List<Category> categories = new ArrayList<>();
    categories.add(new Category(UUID.randomUUID(), "Books"));
    categories.add(new Category(UUID.randomUUID(), "Electronic"));
    return ResponseEntity.ok().body(categories);
  }
}
