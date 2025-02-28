package com.lamld.osadmincentermcr.domain.repositories.user;

import com.lamld.osadmincentermcr.domain.entities.user.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long>, JpaSpecificationExecutor<AccountEntity> {
  AccountEntity findByUsername(String username);
}