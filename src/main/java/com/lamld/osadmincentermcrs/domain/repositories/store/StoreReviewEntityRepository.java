package com.lamld.osadmincentermcrs.domain.repositories.store;

import com.lamld.osadmincentermcrs.domain.entities.store.StoreReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreReviewEntityRepository extends JpaRepository<StoreReviewEntity, Long>, JpaSpecificationExecutor<StoreReviewEntity> {
}