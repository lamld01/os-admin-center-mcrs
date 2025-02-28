package com.lamld.osadmincentermcr.app.response.product;

import com.lamld.osadmincentermcr.domain.entities.product.CategoryEntity;
import lombok.Data;
import vn.mos.core.base.type.ProductCategoryType;

@Data
public class CategoryResponse {

  private Long id;

  private String name;

  private String description;

  private Long parentId;

  private ProductCategoryType type;

  public CategoryResponse(CategoryEntity category) {
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();
    this.parentId = category.getParentId();
    this.type = category.getType();
  }
}
