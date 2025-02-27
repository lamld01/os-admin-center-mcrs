package com.lamld.mossellermcrs.domain.services.store;

import com.lamld.mossellermcrs.app.dto.store.CreateStoreBranchRequest;
import com.lamld.mossellermcrs.app.dto.store.UpdateStoreBranchRequest;
import com.lamld.mossellermcrs.app.response.store.StoreBranchResponse;
import com.lamld.mossellermcrs.domain.entities.store.StoreBranchEntity;
import com.lamld.mossellermcrs.domain.entities.store.StoreEntity;
import com.lamld.mossellermcrs.domain.shareService.store.StoreBranchShareService;
import com.lamld.mossellermcrs.domain.shareService.store.StoreShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.mos.core.base.type.StoreBranchStatus;

@Service
@RequiredArgsConstructor
public class StoreBranchService extends StoreBranchShareService {

  private final StoreShareService storeShareService;

  public StoreBranchResponse createStoreBranch(CreateStoreBranchRequest request) {
    StoreEntity store = storeShareService.getExistStoreById(request.getStoreId());
    StoreBranchEntity storeBranchEntity = createStoreBranch(store, request);
    storeBranchEntity = saveStoreBranch(storeBranchEntity);
    return new StoreBranchResponse(storeBranchEntity);
  }

  public StoreBranchResponse updateStoreBranch(Long id, UpdateStoreBranchRequest request) {
    StoreBranchEntity storeBranchEntity = getExistStoreBranchById(id);
    storeBranchEntity.setName(request.getName());
    storeBranchEntity.setStatus(request.getStatus());
    storeBranchEntity.setAddress(request.getAddress());
    storeBranchEntity.setPhoneNumber(request.getPhoneNumber());
    storeBranchEntity = saveStoreBranch(storeBranchEntity);
    return new StoreBranchResponse(storeBranchEntity);
  }

  public Page<StoreBranchResponse> getPageStoreBranches(Long storeId, String phoneNumber, String name, StoreBranchStatus status, Pageable pageable) {
    Long userId = getRequestUserId();
    Page<StoreBranchEntity> pageBranches = getPageBranches(userId,storeId, name, status, phoneNumber, pageable);
    return mapperUtil.mapPage(pageBranches, StoreBranchResponse.class);
  }

  public StoreBranchResponse getStoreBranchDetail(Long id) {
    StoreBranchEntity storeBranchEntity = getExistStoreBranchById(id);
    return new StoreBranchResponse(storeBranchEntity);
  }
}
