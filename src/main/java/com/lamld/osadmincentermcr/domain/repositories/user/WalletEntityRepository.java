package com.lamld.osadmincentermcr.domain.repositories.user;

import com.lamld.osadmincentermcr.domain.entities.user.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long>, JpaSpecificationExecutor<WalletEntity> {
  WalletEntity findByUserId(Long userId);
}