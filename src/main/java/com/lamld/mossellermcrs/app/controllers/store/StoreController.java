package com.lamld.mossellermcrs.app.controllers.store;

import com.lamld.mossellermcrs.app.dto.store.CreateStoreRequest;
import com.lamld.mossellermcrs.app.dto.store.UpdateStoreRequest;
import com.lamld.mossellermcrs.app.response.store.StoreResponse;
import com.lamld.mossellermcrs.domain.services.store.StoreService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.mos.core.base.BaseResponse;
import vn.mos.core.base.type.PageResponse;

@RestController
@RequestMapping("/v1/admin-center/stores")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/page")
    @PageableAsQueryParam
    public BaseResponse<PageResponse<StoreResponse>> getPageStore(@RequestParam(required = false) String phoneNumber,
                                     @RequestParam(required = false) String name,
                                     @Parameter(hidden = true) Pageable pageable) {
        return BaseResponse.success(PageResponse.fromPage(storeService.getPageStore(phoneNumber, name, pageable)));
    }

    @GetMapping("/{id}/detail")
    public BaseResponse<StoreResponse> getStoreDetail(@PathVariable Long id) {
        return BaseResponse.success(storeService.getStoreDetail(id));
    }

}
