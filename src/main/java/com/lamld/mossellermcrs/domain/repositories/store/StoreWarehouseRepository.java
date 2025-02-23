package com.lamld.mossellermcrs.domain.repositories.store;

import com.lamld.mossellermcrs.domain.entities.store.StoreWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreWarehouseRepository extends JpaRepository<StoreWarehouse, Long>, JpaSpecificationExecutor<StoreWarehouse> {
}