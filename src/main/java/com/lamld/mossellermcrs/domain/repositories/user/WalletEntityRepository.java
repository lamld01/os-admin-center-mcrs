package com.lamld.mossellermcrs.domain.repositories.user;

import com.lamld.mossellermcrs.domain.entities.user.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long>, JpaSpecificationExecutor<WalletEntity> {
  WalletEntity findByUserId(Long userId);
}