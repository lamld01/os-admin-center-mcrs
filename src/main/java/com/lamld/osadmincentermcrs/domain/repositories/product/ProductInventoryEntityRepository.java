package com.lamld.osadmincentermcrs.domain.repositories.product;

import com.lamld.osadmincentermcrs.domain.entities.product.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductInventoryEntityRepository extends JpaRepository<ProductInventoryEntity, Long>, JpaSpecificationExecutor<ProductInventoryEntity> {
}