package com.lamld.osadmincentermcr.domain.services.product;

import com.lamld.osadmincentermcr.app.dto.product.CreateUpdateCategoryRequest;
import com.lamld.osadmincentermcr.app.response.product.CategoryResponse;
import com.lamld.osadmincentermcr.domain.entities.product.CategoryEntity;
import com.lamld.osadmincentermcr.domain.shareService.product.CategoryShareService;
import org.springframework.stereotype.Service;
import vn.mos.core.base.type.ProductCategoryType;

import java.util.List;

@Service
public class CategoryService extends CategoryShareService {
  public CategoryResponse getCategoryDetail(Long id) {
    CategoryEntity category = getExistCategoryById(id);
    return new CategoryResponse(category);
  }

  public CategoryResponse createCategory(CreateUpdateCategoryRequest request) {
    if(request.getParentId() != null) {
      getExistCategoryById(request.getParentId());
    }
    CategoryEntity category = new CategoryEntity();
    category.setName(request.getName());
    category.setDescription(request.getDescription());
    category.setType(request.getType());
    category.setParentId(request.getParentId());
    category = save(category);
    return new CategoryResponse(category);
  }

  public CategoryResponse updateCategory(Long id, CreateUpdateCategoryRequest request) {
    CategoryEntity parentCategory = getExistCategoryById(request.getParentId());
    CategoryEntity category = getExistCategoryById(id);
    category.setName(request.getName());
    category.setDescription(request.getDescription());
    category.setType(request.getType());
    category.setParentId(parentCategory.getId());
    category = save(category);
    return new CategoryResponse(category);
  }

  public List<CategoryResponse> getAllCategory(Long parentId, String name, String description, ProductCategoryType type) {
    List<CategoryEntity> categoryEntities = getAllCategories(parentId, name, description, type);
    return mapperUtil.mapList(categoryEntities, CategoryResponse.class);
  }
}
