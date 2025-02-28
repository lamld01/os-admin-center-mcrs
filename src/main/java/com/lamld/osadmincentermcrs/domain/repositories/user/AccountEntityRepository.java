package com.lamld.osadmincentermcrs.domain.repositories.user;

import com.lamld.osadmincentermcrs.domain.entities.user.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long>, JpaSpecificationExecutor<AccountEntity> {
  AccountEntity findByUsername(String username);
}