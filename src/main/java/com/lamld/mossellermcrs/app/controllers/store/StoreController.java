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
import vn.mos.core.base.type.PageResponse;

@RestController
@RequestMapping("/v1/seller-center/stores")
@RequiredArgsConstructor
@PreAuthorize("hasRole('SELLER')")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/create")
    public StoreResponse createSellerStore(@RequestBody CreateStoreRequest request) {
        return storeService.createStore(request);
    }

    @PutMapping("{id}/update")
    public StoreResponse updateSellerStore(@PathVariable Long id,
                                           @RequestBody UpdateStoreRequest request) {
        return storeService.updateStore(id, request);
    }


    @GetMapping("/page")
    @PageableAsQueryParam
    public PageResponse<StoreResponse> getPageStore(@RequestParam(required = false) String phoneNumber,
                                     @RequestParam(required = false) String name,
                                     @Parameter(hidden = true) Pageable pageable) {
        return PageResponse.fromPage(storeService.getPageStore(phoneNumber, name, pageable));
    }

    @GetMapping("/{id}/detail")
    @PageableAsQueryParam
    public StoreResponse getStoreDetail(@PathVariable Long id) {
        return storeService.getStoreDetail(id);
    }

}
