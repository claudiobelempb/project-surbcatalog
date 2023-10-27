package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryFindAllService {
  private final CategoryRepository categoryRepository;

  public CategoryFindAllService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void execute(){

  }
}
