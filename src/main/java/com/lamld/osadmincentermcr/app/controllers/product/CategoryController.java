package com.lamld.osadmincentermcr.app.controllers.product;

import com.lamld.osadmincentermcr.app.dto.product.CreateUpdateCategoryRequest;
import com.lamld.osadmincentermcr.app.response.product.CategoryResponse;
import com.lamld.osadmincentermcr.domain.services.product.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.mos.core.base.BaseResponse;
import vn.mos.core.base.type.ProductCategoryType;

import java.util.List;

@RestController
@RequestMapping("/v1/admin-center/categories")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping("/{id}/detail")
  public BaseResponse<CategoryResponse> getCategoryDetail(@PathVariable Long id) {
    return BaseResponse.success(categoryService.getCategoryDetail(id));
  }

  @GetMapping("all")
  public BaseResponse<List<CategoryResponse>> getCategoryDetail(@RequestParam(required = false) Long parentId,
                                                                @RequestParam(required = false) String name,
                                                                @RequestParam(required = false) String description,
                                                                @RequestParam(required = false) ProductCategoryType type
  ) {
    return BaseResponse.success(categoryService.getAllCategory(parentId, name, description, type));
  }

  @PostMapping("/create")
  public BaseResponse<CategoryResponse> createCategory(@RequestBody CreateUpdateCategoryRequest request) {
    return BaseResponse.success(categoryService.createCategory(request));
  }

  @PostMapping("{id}/update")
  public BaseResponse<CategoryResponse> createCategory(@PathVariable Long id,
                                                       @RequestBody CreateUpdateCategoryRequest request) {
    return BaseResponse.success(categoryService.updateCategory(id, request));
  }
}
