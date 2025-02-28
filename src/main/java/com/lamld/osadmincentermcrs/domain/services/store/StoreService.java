package com.lamld.osadmincentermcrs.domain.services.store;

import com.lamld.osadmincentermcrs.app.dto.store.CreateStoreRequest;
import com.lamld.osadmincentermcrs.app.dto.store.UpdateStoreRequest;
import com.lamld.osadmincentermcrs.app.response.store.StoreResponse;
import com.lamld.osadmincentermcrs.domain.entities.store.StoreEntity;
import com.lamld.osadmincentermcrs.domain.shareService.store.StoreBranchShareService;
import com.lamld.osadmincentermcrs.domain.shareService.store.StoreShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.mos.core.base.type.StoreStatus;

@Service
@RequiredArgsConstructor
public class StoreService extends StoreShareService {

  private final StoreBranchShareService storeBranchShareService;

  @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
  public StoreResponse createStore(CreateStoreRequest request) {
    StoreEntity store = new StoreEntity();
    store.setName(request.getName());
    store.setPhoneNumber(request.getPhoneNumber());
    store.setStatus(StoreStatus.ACTIVE);
    store = saveStore(store);
    storeBranchShareService.createStoreBranch(store, request);
    return new StoreResponse(store);
  }

  public Page<StoreResponse> getPageStore(String phoneNumber, String name, Pageable pageable) {
    Long userId = getRequestUserId();
    Page<StoreEntity> stores = getPage(userId, phoneNumber, name, pageable);
    return mapperUtil.mapPage(stores, StoreResponse.class);
  }

  public StoreResponse updateStore(Long id, UpdateStoreRequest request) {
    StoreEntity store = getExistStoreById(id);
    store.setName(request.getName());
    store.setPhoneNumber(request.getPhoneNumber());
    store = saveStore(store);
    return new StoreResponse(store);
  }

  public StoreResponse getStoreDetail(Long id) {
    StoreEntity store = getExistStoreById(id);
    return new StoreResponse(store);
  }
}
