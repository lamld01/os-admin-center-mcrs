package com.lamld.osadmincentermcrs.app.dto.product;

import lombok.Data;
import vn.mos.core.base.type.ActiveStatus;
import vn.mos.core.base.type.ProductCategoryType;

@Data
public class CreateUpdateCategoryRequest {

  private String name;

  private String description;

  private Long parentId;

  private ProductCategoryType type;

  private ActiveStatus status;
}
