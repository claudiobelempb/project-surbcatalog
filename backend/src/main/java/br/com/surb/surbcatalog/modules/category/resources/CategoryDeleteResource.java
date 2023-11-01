package br.com.surb.surbcatalog.modules.category.resources;

import br.com.surb.surbcatalog.modules.category.services.CategoryDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping(value = "/categories")
public class CategoryDeleteResource {
  private final CategoryDeleteService categoryDeleteService;

  public CategoryDeleteResource(CategoryDeleteService categoryDeleteService) {
    this.categoryDeleteService = categoryDeleteService;
  }

  @DeleteMapping(value = "/{categoryId}")
  public ResponseEntity<Void> handle(@PathVariable UUID categoryId){
    System.out.println("Delete");
    categoryDeleteService.execute(categoryId);
    return ResponseEntity.noContent().build();
  }
}
