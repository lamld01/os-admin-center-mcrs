package com.lamld.osadmincentermcr.domain.repositories.store;

import com.lamld.osadmincentermcr.domain.entities.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreEntityRepository extends JpaRepository<StoreEntity, Long>, JpaSpecificationExecutor<StoreEntity> {
}