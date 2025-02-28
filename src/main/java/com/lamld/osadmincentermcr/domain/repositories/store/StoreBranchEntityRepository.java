package com.lamld.osadmincentermcr.domain.repositories.store;

import com.lamld.osadmincentermcr.domain.entities.store.StoreBranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreBranchEntityRepository extends JpaRepository<StoreBranchEntity, Long>, JpaSpecificationExecutor<StoreBranchEntity> {
}