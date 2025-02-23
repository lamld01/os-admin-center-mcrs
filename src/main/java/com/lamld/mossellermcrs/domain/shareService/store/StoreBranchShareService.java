package com.lamld.mossellermcrs.domain.shareService.store;

import com.lamld.mossellermcrs.app.dto.store.CreateStoreRequest;
import com.lamld.mossellermcrs.domain.entities.store.StoreBranchEntity;
import com.lamld.mossellermcrs.domain.entities.store.StoreEntity;
import com.lamld.mossellermcrs.domain.repositories.store.StoreBranchEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.mos.core.base.BaseService;
import vn.mos.core.base.type.StoreBranchStatus;

import java.util.List;

@Service
public class StoreBranchShareService extends BaseService {

  @Autowired protected StoreBranchEntityRepository storeBranchRepository;

  public StoreBranchEntity createStoreBranch(StoreEntity store, CreateStoreRequest request) {
   StoreBranchEntity storeBranchEntity = new StoreBranchEntity();
    storeBranchEntity.setStoreId(store.getId());
    storeBranchEntity.setName(request.getName());
    storeBranchEntity.setAddress(request.getAddress());
    storeBranchEntity.setPhoneNumber(request.getPhoneNumber());
    storeBranchEntity.setStatus(StoreBranchStatus.CLOSED);
    return saveStoreBranch(storeBranchEntity);
  }

  public StoreBranchEntity saveStoreBranch(StoreBranchEntity storeBranch) {
    removeStoreBranchCache(storeBranch);
    return storeBranchRepository.saveAndFlush(storeBranch);
  }

  public void removeStoreBranchCache(StoreBranchEntity storeBranch) {
    List<String> keys = List.of(
        redisKey.format(redisKey.format(redisKey.STORE_BRANCH_BY_ID, storeBranch.getId()), storeBranch.getId())
    );
    cacheUtil.delete(keys);
  }
}
