package com.lamld.mossellermcrs.app.controllers.store;

import com.lamld.mossellermcrs.app.dto.store.CreateStoreBranchRequest;
import com.lamld.mossellermcrs.app.dto.store.UpdateStoreBranchRequest;
import com.lamld.mossellermcrs.app.response.store.StoreBranchResponse;
import com.lamld.mossellermcrs.domain.services.store.StoreBranchService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.mos.core.base.BaseResponse;
import vn.mos.core.base.type.PageResponse;
import vn.mos.core.base.type.StoreBranchStatus;

@RestController
@RequestMapping("/v1/admin-center/store-branches")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class StoreBranchController {

  private final StoreBranchService storeBranchService;

  @GetMapping("/page")
  @PageableAsQueryParam
  public BaseResponse<PageResponse<StoreBranchResponse>> getPageStore(
      @RequestParam Long storeId,
      @RequestParam(required = false) String phoneNumber,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) StoreBranchStatus status,
      @Parameter(hidden = true) Pageable pageable) {
    return BaseResponse.success(PageResponse.fromPage(storeBranchService.getPageStoreBranches(storeId, phoneNumber, name, status, pageable)));
  }

  @GetMapping("/{id}/detail")
  public BaseResponse<StoreBranchResponse> getStoreDetail(@PathVariable Long id) {
    return BaseResponse.success(storeBranchService.getStoreBranchDetail(id));
  }

}
