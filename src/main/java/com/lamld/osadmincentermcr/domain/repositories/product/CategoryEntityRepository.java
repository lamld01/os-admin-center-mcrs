package com.lamld.osadmincentermcr.domain.repositories.product;

import com.lamld.osadmincentermcr.domain.entities.product.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long>, JpaSpecificationExecutor<CategoryEntity> {
}